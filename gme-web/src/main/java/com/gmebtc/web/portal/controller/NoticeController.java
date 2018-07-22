package com.gmebtc.web.portal.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.NoticeService;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.CurrencyVO;

/*
 * @Author zhou
 * @Date 2018/5/31 15:22
 * @Desc 系统公告
 */
@RestController
@RequestMapping("${ROOT_PATH}/operation")
public class NoticeController {

	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);

	@Resource(name = "noticeService")
	private NoticeService noticeService;

	/**
	 * 
	 * @Title: getCoinList
	 * @Description: 查询所有币种 （没有条件）
	 * @param request
	 * @param model
	 * @param currencyVO
	 * @return
	 * @return Object
	 */
	@RequestMapping(value = "/coinList", method = RequestMethod.GET)
	public Object getCoinList(HttpServletRequest request, Model model, CurrencyVO currencyVO) {
		ResponseResult result = new ResponseResult();
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		
		try {
			String json = "";
			if (null != currencyVO.getIsToken()) {
				hashMap.put("isToken", currencyVO.getIsToken());
				json= noticeService.getCoinList(request,hashMap);
			}else {
				json = noticeService.getCoinList(request);
			}
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 查询所有币种 解析后台数据发生异常", e.toString());
			return result;
		}
	}

	
	
	/**
	 * 
	* @Title: getCoinTradePairList  
	* @Description: 查询媒介币种对应的币种交易列表
	* @param request
	* @param currencyVO
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/coinTradePairList",method = RequestMethod.GET)
	public Object getCoinTradePairList (HttpServletRequest request,CurrencyVO currencyVO) {
		ResponseResult result = new ResponseResult();
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		if (null != currencyVO.getCurrencyId() && !StringUtils.isBlank(currencyVO.getCurrencyId())) {
			hashMap.put("currencyId", currencyVO.getCurrencyId());
		}
		
		try {
			String json = noticeService.getCoinTradePairList(request,hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 查询媒介币种对应的币种交易列表 解析后台数据发生异常", e.toString());
			return result;
		}
	}
	
	
	
	
	/**
	 * 
	* @Title: getCurrencyDetail  
	* @Description: 币种资料介绍 
	* @param request
	* @param currencyId
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/getCurrencyDetail", method = RequestMethod.GET)
	public Object getCurrencyDetail(HttpServletRequest request, @RequestParam String currencyId) {
		ResponseResult result = new ResponseResult();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("currencyId", currencyId);
		try {
			String json = noticeService.getCoinIntroduce(request, hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 币种资料介绍 解析后台数据发生异常 ", e.toString());
			return result;
		}
	}

	
	
	/**
	 * @throws Exception 
	 * @Author zhou
	 * @Date 2018/5/31 15:31
	 * @Param [request, noticeType:类型，1，行业资讯，2，系统公告，3，帮助, page, pageSize]
	 * @Desc 获取公告
	 */
	@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
	public Object getNotice(HttpServletRequest request, @RequestParam String noticeType,
			@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue="2") String numPerPage) {
		ResponseResult result = new ResponseResult();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("noticeType", noticeType);
		hashMap.put("pageNum", pageNum);
		hashMap.put("numPerPage", numPerPage);
		try {
			String json = noticeService.getNotice(request, hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 获取公告 发生异常", e.toString());
			return result;
		}

	}
	
	
	
	/**
	 * 
	* @Title: getNoticeDetail  
	* @Description: TODO 获取公告详情  
	* @param request
	* @param id
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/getNoticeDetail", method = RequestMethod.GET)
	public Object getNoticeDetail(HttpServletRequest request, @RequestParam String id) {
		ResponseResult result = new ResponseResult();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("noticeId", id);
		
		try {
			String json = noticeService.getNoticeDetail(request, hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 获取公告详情 发生异常", e.toString());
			return result;
		}

	}


}
