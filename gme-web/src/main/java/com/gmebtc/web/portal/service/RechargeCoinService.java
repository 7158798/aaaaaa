package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface RechargeCoinService {
	/**
	 * 
	 * @Title: getWalletRechargeRecord
	 * @Description: TODO 查询充值记录
	 * @param @param request
	 * @param @param hashMap
	 * @param @return
	 * @return String
	 * @throws
	 */
    String getWalletRechargeRecord(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
    /**
     * 
     * @Title: getRechargeAddress
     * @Description: TODO 查询充值地址 分页
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    String getRechargeAddressPage(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
    /**
     * 
    * @Title: getRechargeAddress  
    * @Description: 查询充值地址 
    * @param request
    * @param hashMap
    * @return
    * @return String
     */
    String getRechargeAddress(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
    
}
