package com.gmebtc.web.portal.constant;


/**
 * 
 * @Project：gme-web   
 * @Class：SessionAttributes   
 * @Description 存入session中的key常量    
 * @Author：zhou   
 * @Date：2018年6月27日 上午10:45:29   
 * @version V1.0
 */
public class SessionAttributes {
	
	/**
	 * 验证码存储变量名称
	 */
	public static final String VALIDATE_CODE="VALIDATE_CODE";

	/**
	 * 第一步登录成功
	 */
	public static final String LOGIN_FIRSTLOGIN = "LOGIN_FIRSTLOGIN";
	/**
	 * 第一步登录成功，开启了二步登录，存入session的临时值
	 */
	public static final String LOGIN_FIRSTLOGIN_TEMP = "LOGIN_FIRSTLOGIN_TEMP";
	/**
	 * 第二步登录成功
	 */
	public static final String LOGIN_SECONDLOGIN = "LOGIN_SECONDLOGIN";
	/**
	 * 存用户的账号(页面无法传递)
	 */
	public static final String USER_LOGINID = "USER_LOGINID";
	/**
	 * 存用户重置资金密码的时候的账号
	 */
	public static final String USER_RESETPAYPWD = "USER_RESETPAYPWD";

	/**
	 * 检查用户信息
	 */
	public static final String USER_INFO = "USER_INFO";
	/**
	 * 存用户是否绑定过手机号
	 */
	public static final String USER_ISBINDPHONE = "USER_ISBINDPHONE";
	/**
	 * 存用户是否绑定过邮箱
	 */
	public static final String USER_ISBINDEMAIL = "USER_ISBINDEMAIL";
	/**
	 * 存用户是否实名认证
	 */
	public static final String USER_ISAUTH = "USER_ISAUTH";
	/**
	 * 存用户是否绑定支付宝
	 */
	public static final String USER_ISBINDALIPAY = "USER_ISBINDALIPAY";
	/**
	 * 存用户是否绑定微信
	 */
	public static final String USER_ISBINDWECHAT = "USER_ISBINDWECHAT";
	/**
	 * 存用户是否绑定银行卡
	 */
	public static final String USER_ISBINDBANKCARD = "USER_ISBINDBANKCARD";
	/**
	 * 存用户是否开启二步登录
	 */
	public static final String USER_ISTWOSTEP = "USER_ISTWOSTEP";
	/**
	 * 存用户是否开启了手机提币验证
	 */
	public static final String USER_ISWITHDRAWPHONE = "USER_ISWITHDRAWPHONE";
	/**
	 * 存用户是否开启了邮箱提币验证
	 */
	public static final String USER_ISWITHDRAWEMAIL = "USER_ISWITHDRAWEMAIL";
	/**
	 * 存用户是否是商家
	 */
	public static final String USER_ISBUSINESS = "USER_ISBUSINESS";
	/**
	 * 用户实名认证状态 1未认证 2认证中 3通过认证 4未通过认证
	 */
	public static final String USER_ISAUTHSTATUS = "USER_ISAUTHSTATUS";
	/**
	 * 用户实名认证 未通过认证反馈信息
	 */
	public static final String USER_ISAUTHFAILMESSAGE = "USER_ISAUTHFAILMESSAGE";
	
	
}
