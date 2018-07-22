package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.QuotationService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

@Service(value = "quotationService")
public class QuotationServiceImpl implements QuotationService {

    
    

    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/29 11:54
     * @Param [request, map]
     * @Desc k线接口
     */
    @Override
    public String kline(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("KLINE_KLINE");
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }


    /**
     * 
     * Title: ticker
     * Description: 币行情  带有symbol参数
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.QuotationService#ticker(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String ticker(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("MARKET_TICKET");
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }

    
    /**
     * 
     * Title: ticker
     * Description: 币行情 
     * @param request
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.QuotationService#ticker(javax.servlet.http.HttpServletRequest)
     */
	@Override
	public String ticker(HttpServletRequest request) throws Exception {
		String method = ConfigUtil.get("MARKET_TICKET");
        return SendRequestUtil.sendRequest(request, method);
	}


	/**
	 * 
	 * Title: indexTicker
	 * Description:TODO 首页行情
	 * @param request
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.QuotationService#indexTicker(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String indexTicker(HttpServletRequest request) throws Exception {
		String method = ConfigUtil.get("MARKET_INDEXTICKET");
        return SendRequestUtil.sendRequest(request, method);
	}
}
