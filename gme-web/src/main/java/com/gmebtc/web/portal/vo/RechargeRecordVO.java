package com.gmebtc.web.portal.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @Project：gme-web   
 * @Class：RechargeRecordVO   
 * @Description 类描述：   充值记录分页字段
 * @Author：zzh 
 * @Date：2018年7月2日 上午10:38:37   
 * @version v1.0
 */
public class RechargeRecordVO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * currencyId: 币种类型 
	 */
	private String currencyId;
	/**
	 * status: 状态1-等待确认;2-成功;3-失败;
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
