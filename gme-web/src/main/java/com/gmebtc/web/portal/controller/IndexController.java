package com.gmebtc.web.portal.controller;

import java.util.HashMap;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.IndexService;
import com.gmebtc.web.portal.utils.Toolkits;

/*
 * @Author zhou
 * @Date 2018/5/29 10:19
 * @Desc 首页控制类
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
    @Resource(name = "indexService")
    private IndexService indexService;

    /**
     * @Author zhou
     * @Date 2018/5/29 10:52
     * @Param [request]
     * @Desc 首页Top行情
     */
    @RequestMapping(value = "/topPrice",method = RequestMethod.POST)
    @ResponseBody
    public Object getTopPrice (HttpServletRequest request){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        ResponseResult result = new ResponseResult();
        HashMap<String,String> hashMap = new HashMap<>();
        
        hashMap.put("local", locale.toString());
        
        try {
        	String json = indexService.getTopPrice(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			//result.setMessage(Toolkits.defaultString(map.get(value)));
			result.setData("");
			log.error("{} ", e.toString());
			return result;
		}
    }



    @RequestMapping(value = "/coinInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object getCoinInfo (HttpServletRequest request, @RequestParam String coinType){
        HashMap<String,String> hashMap = new HashMap<>();
        ResponseResult result = new ResponseResult();
        hashMap.put("coinType", coinType);
        
        try {
        	String json = indexService.getCoinInfo(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			//result.setMessage(Toolkits.defaultString(map.get(value)));
			result.setData("");
			log.error("{} ", e.toString());
			return result;
		}
    }


}
