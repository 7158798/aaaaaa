package com.gmebtc.web.portal.vo;

import java.io.Serializable;

/**
 * 
 * @Project：gme-web   
 * @Class：C2CTransVO   
 * @Description 类描述： 我的c2c成交记录分页条件   
 * @Author：zzh 
 * @Date：2018年7月4日 上午10:52:36   
 * @version v1.0
 */
public class C2CTransRecordVO extends BaseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * currencyId: 币种符号
	 */
	private String symbol;
	/**
	 * type: 操作类型 1买入 2 卖出
	 */
	private String type;
	/**
	 * status: 订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;
	 */
	private String status;
	/**
	 * operationType:
	 */
	private String operationType;
	/**
	 * currencyId:
	 */
	private String currencyId;
	
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
