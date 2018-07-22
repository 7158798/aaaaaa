package com.gmebtc.web.portal.tag;

import java.util.HashMap;
import java.util.Map;

import com.gmebtc.web.portal.utils.PropertiesLoader;


/**
 * 全局配置类
 */
public class Global {
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String,String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("spring-control.properties");
	
	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = propertiesLoader.getProperty(key);
			map.put(key, value);
		}
		return value;
	}

	
	/**
	 * 获取访问页面url
	 */
	public static String getAdminPath() {
		return getConfig("ROOT_PATH");
	}
	
	/**
	 * 获取URL后缀
	 */
	public static String getPageUrl() {
		return getConfig("ACCESS_PAGE");
	}
	
}
