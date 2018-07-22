package com.gmebtc.web.portal.vo;

import java.io.Serializable;

/**
 * 
 * @Project：gme-web   
 * @Class：BillVO   
 * @Description 类描述： 账单明细分页   
 * @Author：zzh 
 * @Date：2018年7月3日 下午5:36:52   
 * @version v1.0
 */
public class BillVO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * currencyId: 币种类型
	 */
	private String currencyId;
	/**
	 * bizType: 业务类型1-提现;2-充值;3-交易;4-C2C
	 */
	private String bizType;
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

}
