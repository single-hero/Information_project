package com.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * 启动初始化
 * @author chenwenwei
 * @time 2018.05.05
 */
//为了优化项目,,移除 @SpringBootApplication and @ComponentScan, 用 @EnableAutoConfiguration 来替代

@ComponentScan(basePackages = "com.hero")
//@Configuration
@EnableAutoConfiguration
public class DemoApplication {
	public static void main(String[] args) throws IOException {
//		SpringApplication.run(DemoApplication.class, args);
		ConfigurableApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
		System.out.println("\n");
		//获取字符串
		System.out.println(ctx.getEnvironment().getProperty("system.name"));
		//获取整数
		System.out.println(ctx.getEnvironment().getProperty("system.version",Integer.class));
		System.out.println("====================================================");
	}
}
