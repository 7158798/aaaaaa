package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.OtcService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;



/**
 * 
 * @Project：gme-web   
 * @Class：OtcServiceImpl   
 * @Description 类描述： otc相关   
 * @Author：zzh 
 * @Date：2018年7月7日 上午9:47:31   
 * @version v1.0
 */
@Service("otcService")
public class OtcServiceImpl implements OtcService{

	
	/**
	 * 
	 * Title: busBuyAndSell
	 * Description: 商家买卖usdt
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#busBuyAndSell(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String busBuyAndSell(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_BUSBUYANDSELL");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

	
	/**
	 * 
	 * Title: getDeityList
	 * Description: 查询商家挂单记录
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#getDeityList(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String getDeityList(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_DETIYRECORD");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: c2cUserOrderHistory
	 * Description: c2c用户订单查询
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#c2cUserOrderHistory(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String c2cUserOrderHistory(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_USERORDERHISTORY");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: busCancleOrder
	 * Description: c2c商家取消订单
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#busCancleOrder(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	public String busCancleOrder(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_BUSCANCLE");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: userCancleOrder
	 * Description: 用户取消订单
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#userCancleOrder(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String userCancleOrder(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_USERCANCLEORDER");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}
	
	
	/**
	 * 
	 * Title: c2cBusOrderHistory
	 * Description: c2c查询我的商家接单 
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#c2cBusOrderHistory(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String c2cBusOrderHistory(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OCT_BUSORDERHISTORY");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: userPayFinish
	 * Description: 用户已付款
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#userPayFinish(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String userPayFinish(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_USERFINISHED");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: busCheckFinish
	 * Description: 商家放行
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#busCheckFinish(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String busCheckFinish(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_BUSCHECKFINIS");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: userBuySell
	 * Description: c2c用户下单 
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.OtcService#userBuySell(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String userBuySell(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OTC_USERBUYSELL");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	

}
