package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.IndexService;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/29 10:34
 * @Desc 首页top行情,币种行情
 */
@Service(value = "indexService")
public class IndexServiceImpl implements IndexService {

    
    


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/29 10:38
     * @Param [request, map:存放的是当前语言]
     * @Desc 首页Top行情
     */
    @Override
    public String getTopPrice(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = "getTopPrice&";
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 14:32
     * @Param [request]
     * @Desc 首页币种行情信息
     */
    @Override
    public String getCoinInfo (HttpServletRequest request,HashMap<String,String> hashMap) throws Exception{
        String method = "getCoinInfo&";
        return SendRequestUtil.sendMapRequest(request, hashMap,method);
    }


}
