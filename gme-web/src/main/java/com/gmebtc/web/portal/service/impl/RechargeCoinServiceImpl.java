package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.RechargeCoinService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/31 16:06
 * @Desc 充币
 */
@Service(value = "rechargeCoinService")
public class RechargeCoinServiceImpl implements RechargeCoinService {
    
    

    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 16:28
     * @Param [request, hashMap]
     * @Desc 查询充币记录
     */
    
    public String getWalletRechargeRecord(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
        String method = ConfigUtil.get("WALLET_RECHARGERECORD");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
    
    
    /**
     * @throws Exception 
     * 
     * @Title: getRechargeAddress
     * @Description: TODO 查询充币地址 分页
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    @Override
	public String getRechargeAddressPage(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("WALLET_RECHARGERECORD");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


    /**
     * 
     * Title: getRechargeAddress
     * Description: 查询充值地址
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.RechargeCoinService#getRechargeAddress(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
	@Override
	public String getRechargeAddress(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("WALLET_RECHARGEADDRESS");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

}
