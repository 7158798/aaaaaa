package com.gmebtc.web.portal.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @Project：gme-web   
 * @Class：RechargeRecordVO   
 * @Description 类描述：  提现记录分页字段
 * @Author：zzh 
 * @Date：2018年7月2日 上午10:38:37   
 * @version v1.0
 */
public class WithdrawRecordVO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * currencyId: 币种类型 1.USDT,2.BTC,3.ETH
	 */
	private String currencyId;
	/**
	 * status: 提现状态1-申请;2-处理中;3-已处理;4-已拒绝;5-撤销;
	 */
	private Integer status;
	
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
