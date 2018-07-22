/*
 * 文 件 名  :  CommonConfigUtil.java
 * 版    权    :  Ltd. Copyright (c) 2013 深圳市商巢互联网软件有限公司,All rights reserved
 * 描    述    :  <描述>
 * 创建人    :  彭彩云
 * 创建时间:  下午4:10:52
 */
package com.gmebtc.web.portal.utils;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Project：gme-web   
 * @Class：ConfigUtil   
 * @Description    查找配置文件工具类
 * @Author：zhou   
 * @Date：2018年6月27日 下午7:35:10   
 * @version V1.0
 */
public class ConfigUtil {
	private static final Logger log = LoggerFactory.getLogger(ConfigUtil.class);
	// 对应资源文件config.properties
	private static final ResourceBundle bundle = ResourceBundle
			.getBundle("config");

	/**
	 * 
	 * @Title: get
	 * @Description: TODO 查找配置文件中访问后台url
	 * @param @param key
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static final String get(String key) {
		try {
			return bundle.getString(key);
		} catch (Exception e) {
			log.error("{} {} 没有根据url key在配置文件中查找到相应的value.",e.toString());
			return null;
		}

	}
}
