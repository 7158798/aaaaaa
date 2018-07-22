package com.gmebtc.web.portal.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class ResultCodeMessageUtil {
	
	/**
	 * 服务器异常
	 */
	public final static Integer MsgCode100 = 100;
	private final static String MsgServerError100_CN = "服务器异常,请稍后重试";
	private final static String MsgServerError100_EN = "Server exception,please try again later";

	/**
	 * 未登录
	 */
	public final static Integer MsgCode101 = 101;
	private final static String MsgServerError101_CN = "你还没有登录,请登录后重试";
	private final static String MsgServerError101_EN = "You haven't logged in yet,please login and try again";
	
	/**
	 * 页面表单信息未填写完整
	 */
	public final static Integer MsgCode102 = 102;
	private final static String MsgServerError102_CN = "请填写信息";
	private final static String MsgServerError102_EN = "Please fill in the information";
	
	/**
	 * 未绑定手机
	 */
	public final static Integer MsgCode103 = 103;
	private final static String MsgServerError103_CN = "请先绑定手机";
	private final static String MsgServerError103_EN = "Please bind your cell phone first";
	
	/**
	 * 未实名认证
	 */
	public final static Integer MsgCode104 = 104;
	private final static String MsgServerError104_CN = "请先实名认证";
	private final static String MsgServerError104_EN = "Please first real name certification";
	
	/**
	 * 不是商家
	 */
	public final static Integer MsgCode105 = 105;
	private final static String MsgServerError105_CN = "请先申请为商家";
	private final static String MsgServerError105_EN = "Please apply for the business first";
	
	/**
	 * 未绑定银行卡
	 */
	public final static Integer MsgCode106 = 106;
	private final static String MsgServerError106_CN = "请先绑定银行卡";
	private final static String MsgServerError106_EN = "Please bind the bank card first";
	
	/**
	 * 未绑定支付宝
	 */
	public final static Integer MsgCode107 = 107;
	private final static String MsgServerError107_CN = "请先绑定支付宝";
	private final static String MsgServerError107_EN = "Please bind Alipay first";
	
	/**
	 * 未绑定微信
	 */
	public final static Integer MsgCode108 = 108;
	private final static String MsgServerError108_CN = "请先绑定微信";
	private final static String MsgServerError108_EN = "Please bind WeChat first";
	

	private final static String MsgServerErrorUNKNOW_CN = "未知错误";
	private final static String MsgServerErrorUNKNOW_EN = "UNKNOW";
	
	public static String getCodeMessage(Integer code, HttpServletRequest request) {
		HttpSession session = request.getSession();
	    Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if ("zh_CN".equals(locale.toString())) {
			switch (code) {
			case 100: {
				return MsgServerError100_CN;
			}
			case 101: {
				return MsgServerError101_CN;
			}
			case 102: {
				return MsgServerError102_CN;
			}
			case 103: {
				return MsgServerError103_CN;
			}
			case 104: {
				return MsgServerError104_CN;
			}
			case 105: {
				return MsgServerError105_CN;
			}
			case 106: {
				return MsgServerError106_CN;
			}
			case 107: {
				return MsgServerError107_CN;
			}
			case 108: {
				return MsgServerError108_CN;
			}
			default: {
				return MsgServerErrorUNKNOW_CN;
			}
			}

		} else if ("en_US".equals(locale.toString())) {
			switch (code) {
			case 100: {
				return MsgServerError100_EN;
			}
			case 101: {
				return MsgServerError101_EN;
			}
			case 102: {
				return MsgServerError102_EN;
			}
			case 103: {
				return MsgServerError103_EN;
			}
			case 104: {
				return MsgServerError104_EN;
			}
			case 105: {
				return MsgServerError105_EN;
			}
			case 106: {
				return MsgServerError106_EN;
			}
			case 107: {
				return MsgServerError107_EN;
			}
			case 108: {
				return MsgServerError108_EN;
			}
			default: {
				return MsgServerErrorUNKNOW_EN;
			}
			}

		}

		return null;
	}
}
