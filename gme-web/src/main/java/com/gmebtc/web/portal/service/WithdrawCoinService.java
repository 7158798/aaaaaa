package com.gmebtc.web.portal.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface WithdrawCoinService {
    String cancelWithdraw(HttpServletRequest request, HashMap<String,String> hashMap) throws Exception;

    /**
     * 
     * @Title: withdrawAddressDel
     * @Description: TODO 删除提币地址
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    String withdrawAddressDel(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    /**
     * 
     * @Title: withdrawAddressAdd
     * @Description: TODO 添加提币地址
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    String withdrawAddressAdd(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    /**
     * 
     * @Title: getWithdrawAddress
     * @Description: TODO 查询提币地址
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    String getWithdrawAddress(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
    /**
     * 
     * @Title: widthrawCoin
     * @Description: TODO 
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    String widthrawCoin(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;
    /**
     * 
     * @Title: getWithdrawHistory
     * @Description: TODO 查询提币历史记录
     * @param @param request
     * @param @param hashMap
     * @param @return
     * @return String
     * @throws
     */
    String getWithdrawRecordPage(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
    
    /**
     * 
    * @Title: getWithdrawCharge  
    * @Description: TODO 查询提现手续费 
    * @param request
    * @param hashMap
    * @return
    * @throws Exception
    * @return String
     */
    String getWithdrawCharge(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception;
    
}
