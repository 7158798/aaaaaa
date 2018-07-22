package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface QuotationService {
    String kline(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception;

    String ticker(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception;
    
    String ticker(HttpServletRequest request) throws Exception;
    
    String indexTicker(HttpServletRequest request) throws Exception;
}
