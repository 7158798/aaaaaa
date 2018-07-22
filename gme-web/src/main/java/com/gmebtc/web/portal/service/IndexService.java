package com.gmebtc.web.portal.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface IndexService {
    String getTopPrice(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String getCoinInfo(HttpServletRequest request,HashMap<String,String> hashMap) throws Exception;

}
