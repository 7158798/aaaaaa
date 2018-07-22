package com.gmebtc.web.portal.vo;

import java.io.Serializable;


/**
 * 
 * @Project：gme-web   
 * @Class：CoinVO   
 * @Description 类描述： 币种介绍分页条件   
 * @Author：zzh 
 * @Date：2018年7月4日 下午1:18:07   
 * @version v1.0
 */
/**   
 * @Project：gme-web   
 * @Class：CurrencyVO   
 * @Description 类描述：   
 * @Author：zzh 
 * @Date：2018年7月4日 下午3:48:19   
 * @version v1.0
 */
public class CurrencyVO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * currencySymbol: 币种符号
	 */
	private String currencySymbol;
	/**
	 * isToken: 是否是媒介币，0不是，1是
	 */
	private Integer isToken;
	/**
	 * currencyId: 媒介币的币种id
	 */
	private String currencyId;
	
	
	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getIsToken() {
		return isToken;
	}

	public void setIsToken(Integer isToken) {
		this.isToken = isToken;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
}
