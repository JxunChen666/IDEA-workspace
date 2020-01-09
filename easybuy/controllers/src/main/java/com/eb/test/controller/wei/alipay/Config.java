package com.eb.test.controller.wei.alipay;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("rawtypes")
@Configuration
@SpringBootConfiguration
@EnableTransactionManagement

@Component
public class Config implements ApplicationListener{
	//加载配置类
    //保存加载配置参数
	private static Map<String,String> aliPropertiesMap = new HashMap<String, String>();
    
	//获取配置参数
	public static String getKey(String key) {
		return aliPropertiesMap.get(key);
	}

	//监听启动完成 执行配置加载到alipropertiesmap
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		if(event instanceof ApplicationReadyEvent) {
			//应用启动加载
			System.err.println("应用启动加载");
			this.init(aliPropertiesMap);//↓
		}
	}
	
	
	//初始化加载alippropertiesmap
	public void init(Map<String,String> map) {
		//获得pathmatchingresourcepatternresolver对象
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			//加载resource文件
			System.err.println("加载resource文件");
			Resource resource = resolver.getResource("classpath:alipay.properties");
			PropertiesFactoryBean pfb = new PropertiesFactoryBean();
			System.out.println(resource.exists()+"))))))))))))))))))))))))");
			pfb.setLocation(resource);
			pfb.afterPropertiesSet();
			Properties prop = pfb.getObject();
			//循环遍历所有key value并且存入集合
			for(String key :prop.stringPropertyNames()) {
				map.put(key, (String)prop.get(key));
			}
			
		}catch(Exception e) {
			new Exception("配置文件加载失败");
		}
	}
	//
}
