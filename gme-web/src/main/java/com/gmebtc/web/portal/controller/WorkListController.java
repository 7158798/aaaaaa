package com.gmebtc.web.portal.controller;

import java.util.HashMap;
import java.util.Locale;

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
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.entity.WorkList;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.WorkListService;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.UserVO;

/*
 * @Author zhou
 * @Date 2018/5/30 17:40
 * @Desc 工单系统
 */
@RestController
@RequestMapping("${ROOT_PATH}/operation")
public class WorkListController {
	
	private static final Logger log = LoggerFactory.getLogger(WorkListController.class);
	
    @Resource(name = "workListService")
    private WorkListService workListService;


    
    
    /**
     * 
    * @Title: getWorkListInfo  
    * @Description: 查看我的工单 
    * @param request
    * @param pageNum
    * @param numPerPage
    * @return
    * @return Object
     */
    @RequestMapping(value = "/workListInfo",method = RequestMethod.GET)
    public Object getWorkListInfo (HttpServletRequest request,@RequestParam(defaultValue="1") String pageNum
    								,@RequestParam(defaultValue="10") String numPerPage){
    	HttpSession session = request.getSession();
    	HashMap<String, String> hashMap = new HashMap<String, String>();
		// 调试
		hashMap.put("pageNum", pageNum);
		hashMap.put("numPerPage", numPerPage);
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
    
    	
        try {
        	String json = workListService.getWorkListInfo(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			ResponseResult result = new ResponseResult();
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 查看我的工单 发生异常", e.toString());
			return result;
		}
    }
    
    
    
    
    /**
     * 
    * @Title: listWorkOrderReply  
    * @Description: 查看工单详情 
    * @param request
    * @param subjectId
    * @return
    * @return Object
     */
    @RequestMapping(value = "/listWorkOrderReply",method = RequestMethod.GET)
    public Object listWorkOrderReply (HttpServletRequest request,String subjectId){
    	HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("subjectId", "mlerrfe");
    	
        try {
        	String json = workListService.listWorkOrderReply(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			ResponseResult result = new ResponseResult();
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setData("");
			log.error("{} 查看工单详情 发生异常", e.toString());
			return result;
		}
    }
    
    
    

    /**
     * 
    * @Title: sendWorkList  
    * @Description: 提交工单 
    * @param request
    * @param workList
    * @return
    * @return Object
     */
    @RequestMapping(value = "/sendWorkList",method = RequestMethod.POST)
    public Object sendWorkList (HttpServletRequest request, WorkList workList){
        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        HashMap<String, String> map = new HashMap<>();
        ResponseResult result = new ResponseResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "无效的编号");
            map.put("msg2", "文字描述字数太少");
            map.put("msg3", "服务器异常,请稍后重试");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Invalid number");
            map.put("msg2", "Too few descriptive words");
            map.put("msg3", "Server exception,please try again later.");
        }
        
        result.setCode(ResultCode.FORM_INFO_ERROR);
        result.setData("");
        if (null == workList.getBizId() || StringUtils.isBlank(workList.getBizId())) {
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            return result;
        }
        if (null == workList.getWorkContent() || StringUtils.isBlank(workList.getWorkContent())) {
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            return result;
        }

        
        
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("subject", "随便填,字段暂时保留");
        
        hashMap.put("workType", workList.getWorkType());
        hashMap.put("currencyId", workList.getCurrencyId());
        hashMap.put("bizId", workList.getBizId());
        hashMap.put("workContent", workList.getWorkContent());
        hashMap.put("workImgId", workList.getImgOne() + "," + workList.getImgTwo() + "," + workList.getImgThree());
        UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
        
        try {
        	String json = workListService.sendWorkList(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg3")));
			result.setData("");
			log.error("{} 提交工单 发生异常", e.toString());
			return result;
		}
    }


    
    /**
     * 
    * @Title: replyWorkList  
    * @Description: 用户回复工单 
    * @param request
    * @param subjectId
    * @param context
    * @param replyImgId
    * @param type
    * @return
    * @return Object
     */
    @RequestMapping(value = "/replyWorkList",method = RequestMethod.POST)
    public Object replyWorkList (HttpServletRequest request, @RequestParam String subjectId,String content,String replyImgId,@RequestParam String type){
    	 HttpSession session = request.getSession();
         Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
         HashMap<String, String> map = new HashMap<>();
         ResponseResult result = new ResponseResult();
         if ("zh_CN".equals(locale.toString())) {
             map.put("msg1", "文字描述字数太少");
             map.put("msg2", "服务器异常,请稍后重试");
         }
         if ("en_US".equals(locale.toString())) {
             map.put("msg1", "Too few descriptive words");
             map.put("msg2", "Server exception,please try again later.");
         }
    	
         if (null == content || StringUtils.isBlank(content)) {
        	 result.setCode(ResultCode.FORM_INFO_ERROR);
             result.setMessage(Toolkits.defaultString(map.get("msg1")));
             result.setData("");
             return result;
         }
         
    	
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("subjectId", subjectId);
        hashMap.put("content", content);
        hashMap.put("replyImgId", replyImgId);
        hashMap.put("type", type);
        UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		if (null != userVO) {
			hashMap.put("uid", userVO.getUid());
		}
        
        try {
        	String json = workListService.replyWorkList(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg2")));
			result.setData("");
			log.error("{} 用户回复工单 发生异常", e.toString());
			return result;
		}
    }

}
