package com.gmebtc.web.portal.vo;

import java.io.Serializable;

/**
 * 
 * @Project：gme-web   
 * @Class：TransRecordVO   
 * @Description 类描述： 我的交易记录分页条件   
 * @Author：zzh 
 * @Date：2018年7月4日 上午11:51:02   
 * @version v1.0
 */
public class TransRecordVO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * currencyTokenId: 币种媒介币
	 */
	private String currencySymbol;
	/**
	 * currencyId: 币种id
	 */
	private String currencyId;
	
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

}
