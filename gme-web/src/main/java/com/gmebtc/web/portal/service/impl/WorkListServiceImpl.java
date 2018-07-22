package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.WorkListService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/30 17:43
 * @Desc 工单系统
 */
@Service(value = "workListService")
public class WorkListServiceImpl implements WorkListService {


	/**
	 * 
	 * Title: getWorkListInfo
	 * Description: 查询我的工单
	 * @param request
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.WorkListService#getWorkListInfo(javax.servlet.http.HttpServletRequest)
	 */
    @Override
    public String getWorkListInfo(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("OPERATION_WORKLIST");
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 18:00
     * @Param [request, hashMap]
     * @Desc 提交工单
     */
    @Override
    public String sendWorkList(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("OPERATION_USERSUBMITWORK");
        return SendRequestUtil.sendMapRequest(request,hashMap, method);
    }

    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/6/1 19:40
     * @Param [request, hashMap]
     * @Desc 回复工单
     */
    @Override
    public String replyWorkList(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("OPERATION_USERSUBMITREPLY");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * 
     * Title: listWorkOrderReply
     * Description: 查看工单详情
     * @param request
     * @param hashMap
     * @return  
     * @throws Exception 
     * @see com.gmebtc.web.portal.service.WorkListService#listWorkOrderReply(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
	@Override
	public String listWorkOrderReply(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("OPERATION_REPLYLIST");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}
}
