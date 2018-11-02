package com.hero.util;


import com.hero.controller.BaseController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller Aop切面
 * @author chenwenwei
 * @time 2018.05.11
 */
@Aspect
@Component
public class AOP extends BaseController{
    private long starSystemTime=0;
    private long endSystemTime=0;

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
    @After("Controller_Aop()")
    public void TimeE(){
        //程序执行结束时间
        endSystemTime=System.currentTimeMillis();
        logger.info("请求程序花费:"+(endSystemTime-starSystemTime)+"ms===>"+(float)(endSystemTime-starSystemTime)/1000+"s");
    }

    //切入逻辑(环绕通知)
    @Around("Controller_Aop()")
    public Object Controller(ProceedingJoinPoint point) throws Throwable {

        System.out.println("\n");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info("**********Controller切面Strat**********");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        //创建一个list集合来存储map集合的数据
        List<Map<String,Object>> list=new ArrayList<>();
        //获取请求的参数(这是旧方法)
//        Enumeration<String> paraNames=request.getParameterNames();
//        for(Enumeration<String> e=paraNames;e.hasMoreElements();){
//            String thisName=e.nextElement().toString();
//            String thisValue=request.getParameter(thisName);
//            Map<String,Object>map=new HashMap<>();
//            //获取的参数放到map集合里面
//            map.put(thisName,thisValue);
//            list.add(map);
//        }

        //获取请求参数新方法
        PageData data=this.getPageData();


//        String param=HttpCoder.GetParamPost(request.getInputStream());
//
//        request.setAttribute("jsonObject",param);
//        System.out.println(param);

        // 记录下请求内容
        logger.info("请求url : " + request.getRequestURL().toString());//URL
        logger.info("请求方式 : " + request.getMethod());//HTTP_METHOD
        logger.info("请求ip  : " + GetIp.getIpAddr(request));//IP
        logger.info("调用方法 : " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());//CLASS_METHOD
        logger.info("请求参数 : " + data.toString());
        logger.info("ARGS : " + point.getArgs());
        logger.info("客户端信息:" +UserClient.UserAgent(request));

        //实例化中文转换工具
        ChineseUtill chineseUtill=new ChineseUtill();
//        logger.info("转换后:"+chineseUtill.toChinese(data));

        //执行参数
        Object object=point.proceed(point.getArgs());
        logger.info("**********Controller切面End************");
        return object;
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
}
