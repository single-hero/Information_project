package com.hero.systemBase;


import com.alibaba.fastjson.JSONObject;
import com.hero.util.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller Aop切面
 * @author chenwenwei
 * @time 2018.05.11
 */
@Aspect
@Component
public class AOP extends BaseConfig {
    private long starSystemTime=0;
    private long endSystemTime=0;
    @Value("${KEY}")
    private String key;
    @Value("${KEY_iv}")
    private String iv;
    //Controller做切面
    @Pointcut("execution(* com.hero.controller.*.*(..))")
    public void Controller_Aop(){

    }

    //Service做切面
    @Pointcut("execution(* com.hero.service.*.*(..))")
    public void Service_Aop(){

    }
    @Before("Controller_Aop()")
    public void TimeS(){
        //程序开始时间
        starSystemTime=System.currentTimeMillis();
    }

    //切入逻辑(环绕通知)
    @Around("Controller_Aop()")
    public Object Controller(ProceedingJoinPoint point) throws Throwable {
        //获取请求参数新方法
        PageData data=this.getPageData();
        if(data.size()>0){
            System.out.println("\n");
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            logger.info("**********Controller切面Strat**********");
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            HttpServletResponse response=attributes.getResponse();

            //获取参数解密
            String returnCheckBase=base64Salt(data.getString("eParam"));
            if(returnCheckBase==null){

            }
            String baseDecode=Base64EncodUtil.decode(base64Salt(data.getString("eParam")));
            String aseDecode=AesCBC.getInstance().decrypt(baseDecode,"UTF-8",key,String.valueOf(System.currentTimeMillis()).substring(0,6)+iv);
            try {
                JSONObject jsonObject=JSONObject.parseObject(aseDecode);
                request.setAttribute("jsonParam",jsonObject);
            }catch (Exception e){
                e.printStackTrace();
                response.setStatus(501);
//                return "http://localhost/error/501";
            }
            // 记录下请求内容
            logger.info("请求url : " + request.getRequestURL().toString());//URL
            logger.info("请求方式 : " + request.getMethod());//HTTP_METHOD
            logger.info("请求ip  : " + GetIp.getIpAddr(request));//IP
            logger.info("调用方法 : " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());//CLASS_METHOD
            logger.info("请求参数 : " + data.toString());
            logger.info("解密后  : " +JSONObject.parse(aseDecode));
            logger.info("ARGS : " + point.getArgs());
            logger.info("客户端信息:" + UserClient.UserAgent(request));
            //实例化中文转换工具
            ChineseUtill chineseUtill=new ChineseUtill();
//        logger.info("转换后:"+chineseUtill.toChinese(data));
            logger.info("**********Controller切面End************");
        }
        return point.proceed(point.getArgs());
    }


    // 处理完请求，返回内容
    @AfterReturning(returning = "ret", pointcut = "Controller_Aop()")
    public void doAfterReturning(Object ret) throws Throwable {
        //http请求
        HttpServletRequest httpServletRequest;
        logger.info("**********结果返回Start**********");
        logger.info("RESPONSE : " + ret);
        logger.info("字符编码:");
//        //将获取的Object类型转换成JSON格式对象
//        Object object=JSONObject.toJSON(ret);
//        //然后在将JSON格式对象,转换成JSON对象
//        JSONObject jsonObject=JSONObject.parseObject(object.toString());
//        logger.info("解析后的数据:"+jsonObject);
        logger.info("**********结果返回End************");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @After("Controller_Aop()")
    public void TimeE(){
        //程序执行结束时间
        endSystemTime=System.currentTimeMillis();
        logger.info("请求程序花费:"+(endSystemTime-starSystemTime)+"ms===>"+(float)(endSystemTime-starSystemTime)/1000+"s");
    }
}
