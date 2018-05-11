package com.hero.util;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Controller Aop切面
 * @author chenwenwei
 * @time 2018.05.11
 */
@Aspect
@Component
public class AOP{
    //开启日志
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //Controller做切面
    @Pointcut("execution(* com.hero.controller.*.*(..))")
    public void Controller_Aop(){

    }

    //Service做切面
    @Pointcut("execution(* com.hero.service.*.*(..))")
    public void Service_Aop(){

    }


    //切入逻辑
    @Around("Controller_Aop()")
    public Object Controller(ProceedingJoinPoint point) throws Throwable {
        System.out.println();
        logger.info("**********Controller切面Strat**********");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + GetIp.getIpAddr(request));
        logger.info("CLASS_METHOD : " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(point.getArgs()));
        //执行参数
        Object object=point.proceed(point.getArgs());
        logger.info("**********Controller切面End**********");
        return object;
    }


    // 处理完请求，返回内容
    @AfterReturning(returning = "ret", pointcut = "Controller_Aop()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println();
        logger.info("**********结果返回Start**********");
        logger.info("RESPONSE : " + ret);
        logger.info("**********结果返回End**********");

    }
}
