package com.gmebtc.web.portal.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.BalanceService;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.BillVO;
import com.gmebtc.web.portal.vo.UserVO;

/*
 * @Author zhou
 * @Date 2018/5/29 17:59
 * @Desc 我的资产
 */
@RestController
@RequestMapping("${ROOT_PATH}/finance")
public class BalanceController {
	
	private static final Logger log = LoggerFactory.getLogger(BalanceController.class);
	
	@Resource(name = "balanceService")
	private BalanceService balanceService;

	
	
	/**
	 * 
	* @Title: billList  
	* @Description: TODO 查询我的账单 
	* @param request
	* @param currencyId
	* @param bizType
	* @param startTime
	* @param endTime
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/billList", method = RequestMethod.GET)
	public Object billList(HttpServletRequest request,BillVO billVO,@RequestParam(defaultValue="1") String numPage,
							@RequestParam(defaultValue="10") String numPrePage) {
		HttpSession session = request.getSession();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (null != billVO.getStartTime() && !StringUtils.isBlank(billVO.getStartTime())) {
				hashMap.put("startTime", simple.parse(billVO.getStartTime()).getTime());
			}
			if (null != billVO.getEndTime() && !StringUtils.isBlank(billVO.getEndTime())) {
				hashMap.put("endTime", simple.parse(billVO.getEndTime()).getTime());
			}
		} catch (Exception e) {
			log.error("{} 查询我的账单  页面时间转换失败");
		}
		
		
		if (null != billVO.getCurrencyId() && !StringUtils.isBlank(billVO.getCurrencyId())) {
			hashMap.put("currencyId", billVO.getCurrencyId());
		}
		if (null != billVO.getBizType() && !StringUtils.isBlank(billVO.getBizType())) {
			hashMap.put("bizType", billVO.getBizType());
		}
		
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
		hashMap.put("pageNum", numPage);
		hashMap.put("numPerPage", numPrePage);
		
		
		try {
			String json = balanceService.billList(request,hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			ResponseResult result = new ResponseResult();
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 查询我的账单  解析后台数据发生异常", e.toString());
			return result;
		}
	}
	


	/**
	 * 
	* @Title: accountsCurrent  
	* @Description: TODO 查询我的资产 
	* @param request
	* @param numPage
	* @param numPrePage
	* @param type
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	public Object balance(HttpServletRequest request,@RequestParam(defaultValue="1") String numPage,
							@RequestParam(defaultValue="10") String numPrePage,@RequestParam String type) {
		HttpSession session = request.getSession();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		
		
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
		hashMap.put("pageNum", numPage);
		hashMap.put("numPerPage", numPrePage);
		hashMap.put("type", type);
		
		
		try {
			String json = balanceService.accountsCurrent(request,hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			ResponseResult result = new ResponseResult();
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 查询我的资产  解析后台数据发生异常", e.toString());
			return result;
		}
	}
	

}
