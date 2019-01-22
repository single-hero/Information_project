package com.hero.systemBase;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptor 拦截器
 * @author chenwenwei
 * @time 2019.01.22
 * @content 拦截顺序：filter—>Interceptor—->@Aspect
 */
public class ConfigMyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String path=httpServletRequest.getServletPath();
//        System.out.println("========>>"+path);
        return true;
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("Controller方法调用之后");
    }


    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
//        System.out.println("主要是用于进行资源清理工作");
    }
}
