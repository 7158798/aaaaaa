package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface NoticeService {
	
	String getCoinList(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
	String getCoinList(HttpServletRequest request) throws Exception;
	
	String getCoinTradePairList(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;

    String getCoinIntroduce(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String getNotice(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    String getNoticeDetail(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
}
