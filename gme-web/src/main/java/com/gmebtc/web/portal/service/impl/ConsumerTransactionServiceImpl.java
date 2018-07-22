package com.gmebtc.web.portal.service.impl;

import com.gmebtc.web.portal.service.ConsumerTransactionService;
import com.gmebtc.web.portal.utils.SendRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/*
 * @Author zhou
 * @Date 2018/5/31 17:05
 * @Desc c2c交易
 */
@Service(value = "consumerTransactionService")
public class ConsumerTransactionServiceImpl implements ConsumerTransactionService {

    
    


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:06
     * @Param [request, hashMap]
     * @Desc 买卖usdt
     */
    @Override
    public String c2cBuySellUsdt(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "c2cBuySellUsdt&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:21
     * @Param [request, hashMap]
     * @Desc 商家发布买卖订单
     */
    @Override
    public String c2cBusAddBuySellOrder(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "c2cBusAddBuySellOrder&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:29
     * @Param [request, hashMap]
     * @Desc 商家取消订单
     */
    @Override
    public String c2cBusCanceOrder(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "c2cBusCanceOrder&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:34
     * @Param [request, hashMap]
     * @Desc 获取市场挂单
     */
    @Override
    public String c2cGetBuySellOrders(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "c2cGetBuySellOrders&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:37
     * @Param [request, hashMap]
     * @Desc 用户取消订单
     */
    @Override
    public String c2cCancelByUser(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "c2cCancelByUser&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:41
     * @Param [request, hashMap]
     * @Desc 用户订单记录
     */
    @Override
    public String c2cUserOrderHistory(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "c2cUserOrderHistory&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 17:44
     * @Param [request]
     * @Desc 申请成为商家
     */
    @Override
    public String c2cApplyBus(HttpServletRequest request) throws Exception {
        String method = "c2cApplyBus&";
        return SendRequestUtil.sendRequest(request, method);
    }

}
