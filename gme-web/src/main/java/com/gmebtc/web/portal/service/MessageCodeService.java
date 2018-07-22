package com.gmebtc.web.portal.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface MessageCodeService {

    String getMessageCode(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    String checkPhoneCode(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

}
