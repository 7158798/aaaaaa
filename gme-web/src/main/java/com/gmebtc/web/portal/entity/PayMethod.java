package com.gmebtc.web.portal.entity;

import java.io.Serializable;

/**
 * 
 * @Project：gme-web   
 * @Class：PayMethod   
 * @Description 类描述： 用户支付方式   
 * @Author：zzh 
 * @Date：2018年7月2日 下午6:25:39   
 * @version v1.0
 */
/**   
 * @Project：gme-web   
 * @Class：PayMethod   
 * @Description 类描述：   
 * @Author：zzh 
 * @Date：2018年7月2日 下午6:28:58   
 * @version v1.0
 */
public class PayMethod implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * name: 姓名
	 */
	private String name;
	/**
	 * bank: 银行
	 */
	private String bank;
	/**
	 * branch: 支行
	 */
	private String branch;
	/**
	 * bankCard: 银行卡
	 */
	private String bankCard;
	/**
	 * alipayImg:支付宝二维码
	 */
	private String alipayImg;
	/**
	 * alipayAccount: 支付宝账号
	 */
	private String alipayAccount;
	/**
	 * alipayDesc:描述
	 */
	private String alipayDesc;
	/**
	 * wechatImg: 微信二维码
	 */
	private String wechatImg;
	/**
	 * wechatAccount: 微信账号
	 */
	private String wechatAccount;
	/**
	 * wechatDesc: 微信描述
	 */
	private String wechatDesc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getAlipayImg() {
		return alipayImg;
	}
	public void setAlipayImg(String alipayImg) {
		this.alipayImg = alipayImg;
	}
	public String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	public String getAlipayDesc() {
		return alipayDesc;
	}
	public void setAlipayDesc(String alipayDesc) {
		this.alipayDesc = alipayDesc;
	}
	public String getWechatImg() {
		return wechatImg;
	}
	public void setWechatImg(String wechatImg) {
		this.wechatImg = wechatImg;
	}
	public String getWechatAccount() {
		return wechatAccount;
	}
	public void setWechatAccount(String wechatAccount) {
		this.wechatAccount = wechatAccount;
	}
	public String getWechatDesc() {
		return wechatDesc;
	}
	public void setWechatDesc(String wechatDesc) {
		this.wechatDesc = wechatDesc;
	}
}
