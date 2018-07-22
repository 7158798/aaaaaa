package com.gmebtc.web.portal.vo;

import java.io.Serializable;

/**
 * 
 * @Project：gme-web   
 * @Class：UserVO 页面需要的用户信息   
 * @Description    
 * @Author：zhou   
 * @Date：2018年6月26日 下午9:59:09   
 * @version V1.0
 */
public class UserVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id
	 */
	private String uid;
	/**
	 * 用户账户id
	 */
	private String accountId;
	/**
	 * 用户账户
	 */
	private String account;
	/**
	 * 用户账户余额(CNY)
	 */
	private String balanceCNY;
	/**
	 * 用户账户余额(BTC)
	 */
	private String balanceBTC;
	private String balanceUSDT;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBalanceCNY() {
		return balanceCNY;
	}
	public void setBalanceCNY(String balanceCNY) {
		this.balanceCNY = balanceCNY;
	}
	public String getBalanceBTC() {
		return balanceBTC;
	}
	public void setBalanceBTC(String balanceBTC) {
		this.balanceBTC = balanceBTC;
	}
	public String getBalanceUSDT() {
		return balanceUSDT;
	}
	public void setBalanceUSDT(String balanceUSDT) {
		this.balanceUSDT = balanceUSDT;
	}

}
