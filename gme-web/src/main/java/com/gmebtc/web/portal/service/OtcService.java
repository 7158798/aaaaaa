package com.gmebtc.web.portal.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Project：gme-web   
 * @Class：OtcService   
 * @Description 类描述：c2c相关
 * @Author：zzh 
 * @Date：2018年7月6日 下午8:57:52   
 * @version v1.0
 */
public interface OtcService {
	/**
	 * 
	* @Title: busBuyAndSell  
	* @Description: 商家买卖usdt 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String busBuyAndSell(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	/**
	 * 
	* @Title: getDeityList  
	* @Description: 查询挂单记录 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String getDeityList(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	
	/**
	 * 
	* @Title: c2cUserOrderHistory  
	* @Description: c2c用户订单查询 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String c2cUserOrderHistory(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	
	/**
	 * 
	* @Title: busCancleOrder  
	* @Description: c2c商家取消订单 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String busCancleOrder(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	/**
	 * 
	* @Title: userCancleOrder  
	* @Description: 用户取消订单 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String userCancleOrder(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	
	/**
	 * 
	* @Title: c2cBusOrderHistory  
	* @Description: c2c查询我的商家接单 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String c2cBusOrderHistory(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	
	/**
	 * 
	* @Title: userPayFinish  
	* @Description: 用户已付款 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String userPayFinish(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	
	/**
	 * 
	* @Title: busCheckFinish  
	* @Description: 商家放行 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String busCheckFinish(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	/**
	 * 
	* @Title: userBuySell  
	* @Description: c2c用户下单 
	* @param request
	* @param hashMap
	* @return
	* @return String
	 */
	String userBuySell(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	
	

	
}
