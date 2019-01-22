package com.hero.systemBase;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 将Interceptor注入到spring 容器中
 * @author chenwenwei
 * @time 2019.01.22
 */
@Configuration
public class ConfigInterceptor extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ConfigMyInterceptor())    //指定拦截器类
                .addPathPatterns("/**");        //指定该类拦截的url
    }
}
