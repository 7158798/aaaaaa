package com.gmebtc.web.portal.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface UserRegisterService {
    String userPhoneRegister(HttpServletRequest request,HashMap<String, String> hashMap) throws Exception;


    String userEmaillRegister(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
}