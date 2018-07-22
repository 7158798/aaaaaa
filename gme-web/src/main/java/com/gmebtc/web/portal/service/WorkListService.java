package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface WorkListService {
    String getWorkListInfo(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String sendWorkList(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String replyWorkList(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    String listWorkOrderReply(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
}
