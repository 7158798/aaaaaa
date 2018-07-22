package com.gmebtc.web.portal.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.RechargeCoinService;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.UserVO;

/*
 * @Author zhou
 * @Date 2018/5/31 15:40
 * @Desc 充币
 */
@RestController
@RequestMapping("${ROOT_PATH}/wallet")
public class RechargeCoinController {

	private static final Logger log = LoggerFactory.getLogger(RechargeCoinController.class);

    @Resource(name = "rechargeCoinService")
    private RechargeCoinService rechargeCoinService;
    
    
    
    /**
     * 
     * @Title: getWalletRecharge
     * @Description: TODO 查询充值记录，分页
     * @param @param request
     * @param @param currencyId
     * @param @param pageNum
     * @param @param numPerPage
     * @param @return
     * @return Object
     * @throws
     */
    @RequestMapping(value = "/getWalletRechargeRecord",method = RequestMethod.GET)
    public Object getWalletRechargeRecord (HttpServletRequest request, @RequestParam(required=false) String currencyId,@RequestParam(required=false) String status
                                    ,@RequestParam(defaultValue="1") String pageNum,@RequestParam(defaultValue="10") String numPerPage,String startTime,String endTime) {
    	HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        ResponseResult result = new ResponseResult();
        if ("zh_CN".equals(locale.toString())) {
        	map.put("msg1", "你还没有登录,请登录后重试");
        	map.put("msg2", "服务器异常,请稍后重试");
        }
        if ("en_US".equals(locale.toString())) {
        	map.put("msg1", "You haven't logged in yet,please login and try again");
        	map.put("msg2", "Server exception,please try again later");
        }
        
        
        // 判断当前用户是否已经登录
       /* UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
        if (null == userVO) {
        	result.setCode(ResultCode.FORM_INFO_ERROR);
        	result.setMessage(Toolkits.defaultString(map.get("msg1")));
        	result.setData("");
        	return result;
        }*/
        
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        try {
			if (null != startTime && !StringUtils.isBlank(startTime)) {
				hashMap.put("startTime", simple.parse(startTime).getTime());
			}
			if (null != endTime && !StringUtils.isBlank(endTime)) {
				hashMap.put("endTime", simple.parse(endTime).getTime());
			}
		} catch (Exception e) {
			log.error("{} 查询充值记录  页面时间转换失败");
		}
        
        if (currencyId != null) {
        	hashMap.put("currencyId", currencyId);
        }
        if (status != null) {
        	hashMap.put("status", status);
        }
        
        hashMap.put("pageNum", pageNum);
        hashMap.put("numPerPage", numPerPage);
        UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
		
		
        try {
        	String json = rechargeCoinService.getWalletRechargeRecord(request, hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg2")));
			result.setData("");
			log.error("{} 查询充币记录分页 发生异常.",e.toString());
			return result;
		}
    }
    
    
    
    /**
     * 
     * @Title: getRechargeAddress
     * @Description: TODO 查询充币地址 (BaseController)
     * @param @param request
     * @param @param currencyId
     * @param @return
     * @return Object
     * @throws
     */
    @RequestMapping(value = "/getRechargeAddress",method = RequestMethod.GET)
    @ResponseBody
    public Object getRechargeAddress (HttpServletRequest request,@RequestParam(required=false) String currencyId) {
    	 HttpSession session = request.getSession();
         Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
         Map<String,String> map = new HashMap<String,String>();
         ResponseResult result = new ResponseResult();
         if ("zh_CN".equals(locale.toString())) {
        	 map.put("msg1", "你还没有登录,请登录后重试");
        	 map.put("msg2", "服务器异常,请稍后重试");
         }
         if ("en_US".equals(locale.toString())) {
        	 map.put("msg1", "You haven't logged in yet,please login and try again");
        	 map.put("msg2", "Server exception,please try again later.");
         }
         
         
         result.setCode(ResultCode.FORM_INFO_ERROR);
         
         
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        if (null != currencyId && StringUtils.isBlank(currencyId)) {
        	hashMap.put("currencyId",currencyId);
        }
        
        UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
        
        try {
        	String json = rechargeCoinService.getRechargeAddress(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg2")));
			result.setData("");
			log.error("{} 查询充币地址发生异常",e.toString());
			return result;
		}
    }

}
