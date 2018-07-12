package com.hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

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
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//测试
		long maxMemory = Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存量。
		Long totalMemory = Runtime. getRuntime().totalMemory();//返回Java虚拟机中的内存总量。
		System.out.println("Java虚拟机试图使用的最大内存量->>>MAX_MEMORY ="+maxMemory +"(字节)、"+(maxMemory/(double)1024/1024) + "MB");
		System.out.println("Java虚拟机中的内存总量->>>TOTAL_ MEMORY = "+totalMemory +"(字节)"+(totalMemory/(double)1024/1024) + "MB");
	}
}
