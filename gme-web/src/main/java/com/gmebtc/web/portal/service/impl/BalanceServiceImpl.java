package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.BalanceService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/29 18:02
 * @Desc 我的资产
 */
@Service(value = "balanceService")
public class BalanceServiceImpl implements BalanceService {



    /**
     * 
     * Title: billList
     * Description:TODO 查询我的账单列表
     * @param request
     * @param hashMap
     * @return
     * @throws Exception  
     * @see com.gmebtc.web.portal.service.BalanceService#billList(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
	@Override
	public String billList(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("USER_BILL");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	/**
	 * 
	 * Title: accountsCurrent
	 * Description:TODO 查询我的资产
	 * @param request
	 * @param hashMap
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.BalanceService#accountsCurrent(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String accountsCurrent(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("USER_ASSET");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


}
