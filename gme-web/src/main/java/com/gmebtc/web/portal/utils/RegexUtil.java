package com.gmebtc.web.portal.utils;

import java.util.regex.Pattern;

/**
 * @Description: 正则表达式-工具类 
 * @Author : Jinny.Ding
 * @Date: 2016年9月12日 下午8:13:28
 * @Version: 1.0 .
 * @param <T>
 */
public class RegexUtil extends Regex {
	
	/**
	 * TODO 获取手机号码运营商 
	 * @param phoneNumber
	 * @return  
	 * String
	 */
	public static String getPhoneNumberOperator(String phoneNumber){
		if (!isPhoneNumber(phoneNumber))
			return null;
		if (Pattern.matches(CM, phoneNumber))
			return "中国移动";
		else if (Pattern.matches(CU, phoneNumber))
			return "中国联通";
		else if (Pattern.matches(CT, phoneNumber))
			return "中国电信";
		else 
			return null;
	}
	
	/**
	 * TODO 检测是否是手机号码
	 * @param phoneNumber
	 * @return  
	 * boolean
	 */
	public static boolean isPhoneNumber(String phoneNumber){
		if (StringUtil.isEmpty(phoneNumber))
			return false;
		return Pattern.matches(MOBILE, phoneNumber);
	}
	
	/**
	 * @Title: isEmail
	 * @Description: TODO 检测是否是邮箱地址
	 * @param email
	 * @return 
	 */
	public static boolean isEmail(String email){
		if (StringUtil.isEmpty(email))
			return false;
		return Pattern.matches(SINGLE_EMAIL_REGEX, email);
	}
	
	
	/**
	 * TODO 隐藏手机号中间四位
	 * @param phoneNumber 手机号码
	 * @return  
	 * String
	 */
	public static String hidePhone(String phoneNumber){
		if (StringUtil.isEmpty(phoneNumber))
			return null;
		return phoneNumber.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
	}
	
	/**
	 * TODO 检查是否是数字和字母组合
	 * @param content
	 * @return  
	 * boolean
	 */
	public static boolean isCharAndNumber(String content) {
		if (StringUtil.isEmpty(content)) {
			return false;
		}
		return Pattern.matches(EXTERNAL_ID, content);
	}
	
}
