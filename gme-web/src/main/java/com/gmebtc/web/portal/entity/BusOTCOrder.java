package com.gmebtc.web.portal.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @Project：gme-web   
 * @Class：BusOTCOrder   
 * @Description 类描述： 商家otc买卖   
 * @Author：zzh 
 * @Date：2018年7月7日 上午11:01:16   
 * @version v1.0
 */
public class BusOTCOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * type: 类型 1买入 2卖出
	 */
	private String type;
	/**
	 * price: 价格
	 */
	private BigDecimal price;
	/**
	 * number: 数量
	 */
	private BigDecimal number;
	/**
	 * minMoney: 最小金额
	 */
	private BigDecimal minMoney;
	/**
	 * maxMoney: 最大金额
	 */
	private BigDecimal maxMoney;
	/**
	 * payMethod: 支付方式：00-前两位表示是否银行卡支付;00-中间两位表示是否支付宝支付;00-最后两位表示是否微信支付;其中，01表示是;02表示否;
	 */
	private String payMethod;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(BigDecimal minMoney) {
		this.minMoney = minMoney;
	}
	public BigDecimal getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(BigDecimal maxMoney) {
		this.maxMoney = maxMoney;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
}
