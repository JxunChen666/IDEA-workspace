package com.fangjian.zhenbao.base.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * 获取配置参数
 * @author zhongtianyi
 */
public final class ConfigUtil {
	private ConfigUtil() {
	}

	private static Properties props = null;
	private static LoadingCache<String, String> cahceBuilder = null;
	static {
		try {
			
			props = PropertiesLoaderUtils.loadAllProperties("resources.properties");
			cahceBuilder = CacheBuilder.newBuilder().maximumSize(100).build(new CacheLoader<String, String>() {
				@Override
				public String load(String key) throws Exception {
				 
					return getValueByKey(key);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			// 如果加载配置文件失败，则关闭程序
			System.out.println("如果加载配置文件失败，则关闭程序");
			System.exit(1);
		}
	}

	private static String getValueByKey(String key) {
		return props.getProperty(key);
	}
	public static String get(String key) {
		try {
			return cahceBuilder.get(key);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static String get(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
}
