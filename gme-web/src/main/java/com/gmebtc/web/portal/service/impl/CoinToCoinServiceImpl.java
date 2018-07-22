package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.CoinToCoinService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;


/*
 * @Author zhou
 * @Date 2018/5/30 17:05
 * @Desc 币币交易
 */
@Service(value = "coinToCoinService")
public class CoinToCoinServiceImpl implements CoinToCoinService {

    
    


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 17:05
     * @Param [request]
     * @Desc 取消订单
     */
    @Override
    public String cancelCoinOrder(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("COIN_CANCELORDER");
        return SendRequestUtil.sendMapRequest(request, hashMap,method);
    }


    
    /**
     * 
     * Title: bbBuySell
     * Description:  币币交易
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.CoinToCoinService#bbBuySell(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String bbBuySell(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("COIN_BUYSELL");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    
    /**
     * 
     * Title: realTimeTradeRecord
     * Description: 平台实时交易记录
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.CoinToCoinService#realTimeTradeRecord(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String realTimeTradeRecord(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("COIN_REALTIMETRADE");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * 
     * Title: getUserTransactions
     * Description: 查询我的交易记录
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.CoinToCoinService#getUserTransactions(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String transRecord(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("COIN_TRADERECORD");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * 
     * Title: entrustRecord
     * Description: 我的委托记录
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.CoinToCoinService#entrustRecord(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String entrustRecord(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("COIN_ENTRUSTRECORD");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    
    /**
     * 
     * Title: getBuySellOrders
     * Description: 买卖委托单
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.CoinToCoinService#getBuySellOrders(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String getBuySellOrders(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("COIN_BUYSELLORDER");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }



    /**
     * 
     * Title: queryDetial
     * Description: 查询详情
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.CoinToCoinService#queryDetial(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
	@Override
	public String queryDetial(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "aaaa";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}
}
