package com.gmebtc.web.portal.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface BalanceService {

	String billList(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
	String accountsCurrent(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
}
