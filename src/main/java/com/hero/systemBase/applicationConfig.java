package com.hero.systemBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


/**
 * 读取配置文件
 * @author chenwenwei
 * @time 2018.12.27
 */
@Component
public class applicationConfig {
	private static final String configFileName = "/project/information/application.properties";
	// 开启日志记录
	private static final Logger logger = LoggerFactory.getLogger(applicationConfig.class);

	private static String KEY = null;
	private static String iv = null;
	private static int sessionTimeOut = 0;
	static{
		init();
	}

	// 初始化
	public static void init() {
		//读取数据源信息
		Properties props = new Properties();
		try {
			props.load(new InputStreamReader(new FileInputStream(configFileName),"UTF-8"));
		} catch (IOException e) {
//			logger.error("加载本地配置文档失败");
			try {
				//加载开发环境配置文件
				Resource resource = new ClassPathResource("application-dev.properties");
				props = PropertiesLoaderUtils.loadProperties(resource);
			} catch (Exception ei) {
				logger.error("加载内部配置文档失败");
				return;
			}
		}

		//对常量进行赋值
//		sessionTimeOut = Integer.valueOf(props.getProperty("sessionTimeOut"));
		KEY=props.getProperty("KEY");
		iv=props.getProperty("KEY_iv");
	}

	public static String getKEY(){
		return KEY;
	}
	public static String getIv(){
		return iv;
	}
//	public static int getSessionTimeOut(){
//		return sessionTimeOut;
//	}
}
