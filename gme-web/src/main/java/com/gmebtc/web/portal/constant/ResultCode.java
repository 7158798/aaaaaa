package com.gmebtc.web.portal.constant;


/**
 * 
 * @Project：gme-web   
 * @Class：ResultCode   
 * @Description 返回给前端的code    
 * @Author：zhou   
 * @Date：2018年6月27日 下午12:01:11   
 * @version V1.0
 */
public class ResultCode {

	/**
	 * 请求成功，资源成功响应
	 */
	public static final Integer SUCCESS = 200; 
	/**
	 * 用户不存在
	 */
	public static final Integer NO_USER = 20401;
	/**
	 * 登录成功，开启二次验证
	 */
	public static final Integer SECOND_LOGIN = 205;
	/**
	 * 	请求参数无效,没有被授权访问的资源操作
	 */
	public static final Integer WEB_ERROR = 400;
	/**
	 * 用户没有通过验证
	 */
	public static final Integer NO_PASS_VALIDATE = 401;
	/**
	 * 用户已注册，请直接登录
	 */
	public static final Integer USER_ALREADY_REGISTER = 402;
	/**
	 * 用户名或密码校验错误
	 */
	public static final Integer LOGINID_PASSWORD_ERROR = 405;
	/**
	 * 服务器端执行请求时发生错误
	 */
	public static final Integer SYSTEM_ERROR = 500;
	
	
	
	
	
	
	
	/**
	 * web检查页面填写的信息有误
	 */
	public static final Integer FORM_INFO_ERROR = 444;
	public static final Integer USER_ISNOTLOGIN = 555;
	
	
}
