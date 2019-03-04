package com.hero.systemBase;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * filter 过滤器
 * @author chenwenwei
 * @time 2019.01.22
 * @content 拦截顺序：filter—>Interceptor—->@Aspect
 */
@Component
@WebFilter(urlPatterns = { "/**" }, filterName = "tokenAuthorFilter")
public class ConfigurationFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("CharacterEncoding",servletRequest.getCharacterEncoding());
        servletRequest.setAttribute("systemAuthor","chenwenwei");
        //将ServletResponse向上转HttpServletResponse（安全）,HttpServletResponse向下转(不安全)
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        //设置允许跨域访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        //设置允许请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        //设置浏览器发起预检请求间隔时间(1小时)
        response.setHeader("Access-Control-Max-Age","3600");
        //设置允许发起预检请求头信息
        response.setHeader("Access-Control-Allow-Headers","content-type");

        filterChain.doFilter(servletRequest, servletResponse);//到下一个链
    }

    @Override
    public void destroy() {
//        System.out.println("过滤器销毁");
    }
}
