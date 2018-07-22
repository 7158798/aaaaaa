package com.gmebtc.web.portal.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.result.ResponseResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/**
 * 实用工具类。
 * Mar 6, 2014 3:15:41 PM
 */
public final class Toolkits{
	
	private static final Logger log = LoggerFactory.getLogger(Toolkits.class);
	private static final JsonParser jsonParser = new JsonParser();
	private static Gson gson = null;

	
	static
	{
		//构建gson翻译器。
		GsonBuilder gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.create();
	}
	private static final String[] ARRAY_SPECIAL_SCALE34 = 
	{
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
		"A", "B", "C", "D", "E", "F", "G", "H", "J", "K",
		"L", "M", "N", "P", "Q", "R", "S", "T", "U", "V",
		"W", "X", "Y", "Z",
	};



	/**
	 * 返回对象的默认字符串形式。如果对象为空，则返回str定义的字符串。
	 * @param object 参数对象。
	 * @return 字符串。
	 */
	public static final String defaultString(Object object)
	{
		return defaultString(object, StringUtils.EMPTY);
	}

	/**
	 * 返回对象的默认字符串形式。如果对象为空，则返回str定义的字符串。
	 * @param object 参数对象。
	 * @param str 默认返回的字符串。
	 * @return 字符串。
	 */
	public static final String defaultString(Object object, String str)
	{
		if(object != null && object.equals("null"))
		{
			object = null;
		}
		return (object == null)? str: object.toString();
	}




	/**
	 * 获取客户端的IP地址。
	 * @param request HttpServletRequest 实例。
	 * @return 客户端的IP地址。
	 */
	public static final String getIpAddress(HttpServletRequest request)
	{
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 将对象转换为JSON字符串。
	 * @param objecr 要转换的对象。
	 * @return 转换后的字符串。
	 */
	public static final String fromPojotoJson(Object objecr)
	{
		String returnJson = "";
		if(objecr != null)
		{
			returnJson = gson.toJson(objecr);
		}
		return returnJson;
	}

	/**
	 * 将一个json字符串按配置进行美化输出。
	 * @param json json字符串。
	 * @return 美化后的字符串。
	 */
	public static final String toJson(String json)
	{
		String returnJson = "";
		if(!defaultString(json).equals(""))
		{
			returnJson = gson.toJson(jsonParser.parse(json));
		}
		return returnJson;
	}

	/**
	 * 将JSON字符串转换为对象。
	 * @param json json字符串。
	 * @param clazz 目标对象类类型。
	 * @return 转换后的对象。
	 */
	public static final Object fromJsonToPojo(String json, Class<?> clazz)
	{
		Object returnObject = null;
		if(!defaultString(json).equals("") && clazz != null)
		{
			returnObject = gson.fromJson(json, clazz);
		}
		return returnObject;
	}

	
	
	/**
	 * 
	 * @Title: HandleResp
	 * @Description: TODO 处理从后台返回的json数据
	 * @param @param request
	 * @param @param json
	 * @param @return
	 * @return ResponseResult
	 * @throws
	 */
	public static ResponseResult handleResp (String json){
		ResponseResult result = new ResponseResult();
		try {
			result = (ResponseResult) fromJsonToPojo(json, ResponseResult.class);
			if (result.getCode().toString().startsWith("1")) {
				result.setMessage("服务器正在处理,请稍等");
				log.info("后台返回状态码code:{}",result.getCode());
				return result;
			}else if (result.getCode().toString().startsWith("4")) {
				if (result.getCode().equals(ResultCode.NO_PASS_VALIDATE)) {
					result.setMessage("你没有通过验证,请重新验证后重试");
					log.error("{} 后台返回状态码code:{}",result.getCode());
					return result;
				}
				if (result.getCode().equals(ResultCode.USER_ALREADY_REGISTER)) {
					result.setMessage("此账号已被注册，请直接登录");
					log.error("{} 后台返回状态码code:{}",result.getCode());
					return result;
				}
				if (result.getCode().equals(ResultCode.LOGINID_PASSWORD_ERROR)) {
					result.setMessage("用户名或密码验证错误");
					log.error("{} 后台返回状态码code:{}",result.getCode());
					return result;
				}
				// 参数传递错误，内部错误，不提示消息
				result.setCode(ResultCode.WEB_ERROR);
				result.setMessage("");
				log.error("{} 后台返回状态码code:{}",result.getCode());
				return result;
			}
			return result;
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage("服务器异常,请稍后重试");
			result.setData("");
			log.error("{} 处理后台返回的结果出现错误",e.toString());
			return result;
		}
	}
	
	
	/**
	 * 是否为邮箱
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isPhone (String phone){
//		String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
		String regExp = "1[358][0-9]{9}";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phone);
		return m.matches();
	}
	
	
	// 验证从前台传的表单数据是否为空
	public static boolean isBlank(Object...value) {
		for (int i = 0; i < value.length; i++) {
			try {
				// 说明是integer为null,转换异常
				value[i].getClass();
			} catch (Exception e) {
				return true;
			}
    		if (value[i] instanceof String) {
    			if (value[i] == "" || StringUtils.isBlank(value[i].toString())) {
    				return true;
    			}
    		}
    	}
		return false;
	}
}