package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.WithdrawCoinService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/29 17:11
 * @Desc 提币service
 */
@Service(value = "withdrawCoinService")
public class  WithdrawCoinServiceImpl implements WithdrawCoinService {

    
    


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/29 17:12
     * @Param [request, withdrawId:	提币编号, payPassword:资金密码]
     * @Desc 取消提币
     */
    @Override
    public String cancelWithdraw(HttpServletRequest request, HashMap<String,String> hashMap) throws Exception {
        String method = "cancelWithdraw&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/29 17:25
     * @Param [request, hashMap]
     * @Desc 删除钱包地址
     */
    @Override
    public String withdrawAddressDel(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("WALLET_DELETEWALLETADDRESS");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/29 21:04
     * @Param [request, hashMap]
     * @Desc 添加提币地址
     */
    @Override
    public String withdrawAddressAdd(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("WALLET_ADDWITHDRAWADDRESS");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 10:53
     * @Param [request, hashMap]
     * @Desc 查询提币地址
     */
    @Override
    public String getWithdrawAddress(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
        String method = ConfigUtil.get("WALLET_WITHDRAWADDRESS");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 16:43
     * @Param [request, hashMap]
     * @Desc 提币请求
     */
    @Override
    public String widthrawCoin(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("WALLET_ADDWITHDRAW");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    
    /**
     * 
    * @Title: getWithdrawRecordPage  
    * @Description:  分页查询提币记录
    * @param request
    * @param hashMap
    * @return
    * @return String
     * @throws Exception 
     */
    @Override
    public String getWithdrawRecordPage(HttpServletRequest request,HashMap<String,Object> hashMap) throws Exception {
        String method = ConfigUtil.get("WALLET_WITHDRAWPAGE");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * 
     * Title: getWithdrawCharge
     * Description:TODO 查询提现手续费
     * @param request
     * @param hashMap
     * @return
     * @throws Exception  
     * @see com.gmebtc.web.portal.service.WithdrawCoinService#getWithdrawCharge(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
	@Override
	public String getWithdrawCharge(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("WALLET_WITHDRAWCHARGE");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}



}
