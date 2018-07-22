package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;

import com.gmebtc.web.portal.utils.Toolkits;

import java.util.HashMap;

public interface CoinToCoinService {
    String cancelCoinOrder(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception;

    String bbBuySell(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String realTimeTradeRecord(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String transRecord(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String entrustRecord(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String getBuySellOrders(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    String queryDetial(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    
    
}
