package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.NoticeService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/31 15:28
 * @Desc 系统公告
 */
@Service(value = "noticeService")
public class NoticeServiceImpl implements NoticeService {
    
    
    
    


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 15:29
     * @Param [request, hashMap]
     * @Desc 币种介绍
     */
    @Override
    public String getCoinIntroduce(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("OPERATION_COINDETAIL");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 15:32
     * @Param [request, hashMap]
     * @Desc 获取公告
     */
    @Override
    public String getNotice(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("OPERATION_NOTICELIST");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * 
     * Title: getCoinList
     * Description: 查询所有币种
     * @param request
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.NoticeService#getCoinList(javax.servlet.http.HttpServletRequest)
     */
	@Override
	public String getCoinList(HttpServletRequest request,HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OPERATION_COINLIST");
		return SendRequestUtil.sendMapRequest(request,hashMap, method);
	}

	/**
	 * 
	 * Title: getCoinList
	 * Description:TODO 查询所有币种 
	 * @param request
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.NoticeService#getCoinList(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public String getCoinList(HttpServletRequest request) throws Exception {
		String method = ConfigUtil.get("OPERATION_COINLIST");
		return SendRequestUtil.sendRequest(request, method);
	}
	
	
	/**
	 * 
	 * Title: getCoinTradePairList
	 * Description: 查询媒介币种对应的币种交易列表
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.NoticeService#getCoinTradePairList(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String getCoinTradePairList(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception {
		String method = ConfigUtil.get("OPERATION_CURRENCYBYTOKENID");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	
	/**
	 * 
	 * Title: getNoticeDetail
	 * Description:TODO 获取公告详情
	 * @param request
	 * @param hashMap
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.NoticeService#getNoticeDetail(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String getNoticeDetail(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("OPERATION_NOTICEDETAIL");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}


	
}
