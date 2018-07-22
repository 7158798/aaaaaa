package com.gmebtc.web.portal.entity;

import java.io.Serializable;

/**
 * 
 * @Project：gme-web   
 * @Class：UserInfo   
 * @Description 类描述： 检查用户信息   
 * @Author：zzh 
 * @Date：2018年7月2日 下午6:23:57   
 * @version v1.0
 */
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * idCard: 身份证号
	 */
	private String idCard;
	/**
	 * email: 邮箱
	 */
	private String email;
	/**
	 * phone: 手机号
	 */
	private String phone;
	/**
	 * payMethod: 支付方式
	 */
	private PayMethod payMethod;
	/**
	 * isIdentityAuthApply: 是否实名认证
	 */
	private Integer isIdentityAuthApply;
	/**
	 * authStatus: 认证状态:1-未认证;2-认证中;3-已通过认证;4-未通过认证;
	 */
	private Integer authStatus;
	/**
	 * authFeedback: 未通过认证后反馈信息
	 */
	private String authFeedback;
	
	/**
	 * isAlipay:是否开启支付宝
	 */
	private Integer isAlipay;
	/**
	 *isBankCard:是否开启银行卡
	 */
	private Integer isBankCard;
	/**
	 *isWechat: 是否开启微信
	 */
	private Integer isWechat;
	/**
	 *isBindEmail:是否绑定邮箱
	 */
	private Integer isBindEmail;
	/**
	 *isBindPhone: 是否绑定手机
	 */
	private Integer isBindPhone;
	/**
	 * isTwoStep: 是否开启二步登录
	 */
	private Integer isTwoStep;
	/**
	 * isWithdrawCoinCheckPhone: 是否开启手机提币验证登录
	 */
	private Integer isWithdrawCoinCheckPhone;
	/**
	 * isWithdrawCoinCheckEmail: 是否开启邮箱提币验证登录
	 */
	private Integer isWithdrawCoinCheckEmail;
	/**
	 * isBusiness:是否是商家
	 */
	private Integer isBusiness;
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public PayMethod getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}
	public Integer getIsIdentityAuthApply() {
		return isIdentityAuthApply;
	}
	public void setIsIdentityAuthApply(Integer isIdentityAuthApply) {
		this.isIdentityAuthApply = isIdentityAuthApply;
	}
	public Integer getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}
	public Integer getIsAlipay() {
		return isAlipay;
	}
	public void setIsAlipay(Integer isAlipay) {
		this.isAlipay = isAlipay;
	}
	public Integer getIsBankCard() {
		return isBankCard;
	}
	public void setIsBankCard(Integer isBankCard) {
		this.isBankCard = isBankCard;
	}
	public Integer getIsWechat() {
		return isWechat;
	}
	public void setIsWechat(Integer isWechat) {
		this.isWechat = isWechat;
	}
	public Integer getIsBindEmail() {
		return isBindEmail;
	}
	public void setIsBindEmail(Integer isBindEmail) {
		this.isBindEmail = isBindEmail;
	}
	public Integer getIsBindPhone() {
		return isBindPhone;
	}
	public void setIsBindPhone(Integer isBindPhone) {
		this.isBindPhone = isBindPhone;
	}
	public Integer getIsTwoStep() {
		return isTwoStep;
	}
	public void setIsTwoStep(Integer isTwoStep) {
		this.isTwoStep = isTwoStep;
	}
	public Integer getIsWithdrawCoinCheckPhone() {
		return isWithdrawCoinCheckPhone;
	}
	public void setIsWithdrawCoinCheckPhone(Integer isWithdrawCoinCheckPhone) {
		this.isWithdrawCoinCheckPhone = isWithdrawCoinCheckPhone;
	}
	public Integer getIsWithdrawCoinCheckEmail() {
		return isWithdrawCoinCheckEmail;
	}
	public void setIsWithdrawCoinCheckEmail(Integer isWithdrawCoinCheckEmail) {
		this.isWithdrawCoinCheckEmail = isWithdrawCoinCheckEmail;
	}
	public String getAuthFeedback() {
		return authFeedback;
	}
	public void setAuthFeedback(String authFeedback) {
		this.authFeedback = authFeedback;
	}
	public Integer getIsBusiness() {
		return isBusiness;
	}
	public void setIsBusiness(Integer isBusiness) {
		this.isBusiness = isBusiness;
	}
	
	
}
