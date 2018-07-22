package com.gmebtc.web.portal.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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
import com.gmebtc.web.portal.entity.User;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.UserLoginService;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.UserVO;

/**
 * @Author zhou
 * @Date 2018/5/28 11:59
 * @Desc 用户登录,忘记登录密码,注销登录 控制类
 */
@RestController
@RequestMapping(value = "${ROOT_PATH}/user")
public class UserLoginController {

	private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);
	
    @Resource(name = "userLoginService")
    private UserLoginService userLoginService;


    /**
     * @throws ServletException 
     * @throws IOException 
     * 
     * @Title: userLogin
     * @Description: TODO 用户登录
     * @param @param request
     * @param @param user
     * @param @return
     * @return Object
     * @throws
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object userLogin (HttpServletRequest request,User user){
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        ResponseResult result = new ResponseResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "登录账号不能为空");
            map.put("msg2", "登录账号格式不正确");
            map.put("msg3", "登录密码不能为空");
            map.put("msg4", "图片验证码不正确");
            map.put("msg5", "服务器异常,请稍后重试");
            map.put("msg6", "你已登录");
            
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "The login account cannot be empty");
            map.put("msg2", "Login account format is not correct");
            map.put("msg3", "The login password can not be empty");
            map.put("msg4", "Image verification code is incorrect");
            map.put("msg5", "Server exception,please try again later");
            map.put("msg6", "You have logged in");
        }
        
        result.setCode(ResultCode.FORM_INFO_ERROR);
        
        // 判断图片验证码是否正确
        String validateCode = (String) session.getAttribute(SessionAttributes.VALIDATE_CODE);
        if (null == validateCode || !user.getImgCode().equalsIgnoreCase(validateCode)) {
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (null == user.getLoginId() || StringUtils.isBlank(user.getLoginId())) {
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isEmail(user.getLoginId()) && !Toolkits.isPhone(user.getLoginId())) {
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData(""); 
            return result;
        }
        if (null == user.getPassword() || StringUtils.isBlank(user.getPassword())) {
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("loginId", user.getLoginId());
        hashMap.put("password", user.getPassword());
        hashMap.put("ip", Toolkits.getIpAddress(request));
        hashMap.put("loginTime", new Date().getTime());
        
        try {
        	UserVO userVO = null;
        	// 判断用户是否已经登录，如果已经登录，提示不可重复登录
        	userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
        	if (null != userVO) {
        		result.setCode(ResultCode.FORM_INFO_ERROR);
        		result.setMessage(Toolkits.defaultString(map.get("msg6")));
        		result.setData("");
        		return result;
        	}
        	String json = userLoginService.login(request,hashMap);
        	// 如果用户登录成功,获取用户的登录状态
        	result = (ResponseResult) Toolkits.fromJsonToPojo(json, ResponseResult.class);
        	if (null != result) {
        		// 用户开启二步登录,并且用户第一步登录已经成功
        		if (result.getCode().equals(ResultCode.SECOND_LOGIN)) {
        			userVO = (UserVO) Toolkits.fromJsonToPojo(Toolkits.fromPojotoJson(result.getData()), UserVO.class);
        			// 记录用户第一步登录成功,并将状态码返回给前端判断是否前往第二步登录
        			session.setAttribute(SessionAttributes.LOGIN_FIRSTLOGIN_TEMP,userVO);
        			
        			return result;
        		// 用户没有开启二次验证并且登录成功
        		}else if (result.getCode().equals(ResultCode.SUCCESS)){
        			userVO = (UserVO) Toolkits.fromJsonToPojo(Toolkits.fromPojotoJson(result.getData()), UserVO.class);
        			session.setAttribute(SessionAttributes.LOGIN_SECONDLOGIN, userVO);
        		}
        	}
        	return Toolkits.handleResp(json);
        } catch (Exception e) {
        	result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg5")));
			result.setData("");
			log.error("{} 用户登录.处理后台返回的结果出现错误.",e.toString());
			return result;
		}
    }


    
    
    
    /**
     * @Author zhou
     * @Date 2018/5/28 14:33
     * @Param [request]
     * @Desc 用户登出
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Object userLogout (HttpServletRequest request){
    	HttpSession session = request.getSession();
    	 // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        ResponseResult result = new ResponseResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "服务器异常,请稍后重试");
            map.put("msg2", "你还没有登录,请登录后重试");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Server exception,please try again later.");
            map.put("msg2", "You haven't logged in yet,please login and try again");
        }
        
        HashMap<String, String> hashMap = new HashMap<String, String>();
        
    	try {
    		//得到用户session
    		UserVO userVO = (UserVO) request.getSession().getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
    		if (null != userVO) {
    			hashMap.put("uid", userVO.getUid());
    			String json = userLoginService.logout(request,hashMap);
    			result = (ResponseResult) Toolkits.fromJsonToPojo(json, ResponseResult.class);
    			// 如果后台确认了登出,清除session
    			if (null != result && result.getCode().equals(ResultCode.SUCCESS)) {
    				request.getSession().setAttribute(SessionAttributes.LOGIN_SECONDLOGIN, null);
    			}
    			return Toolkits.handleResp(json);
    		}else {
    			result.setCode(ResultCode.FORM_INFO_ERROR);
    			result.setMessage(Toolkits.defaultString(map.get("msg2")));
    			result.setData("");
    			return result;
    		}
    	} catch (Exception e) {
    		result.setCode(ResultCode.SYSTEM_ERROR);
    		result.setMessage(Toolkits.defaultString(map.get("msg1")));
    		result.setData("");
    		log.error("{} 用户登出发生异常.",e.toString());
    		return result;
		}
    }
    
    
    /**
     * 
    * @Title: resetPassword  
    * @Description: TODO 重置登录密码 
    * @param request
    * @param account
    * @param password
    * @return
    * @return Object
     */
    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public Object resetPassword (HttpServletRequest request,@RequestParam String account ,@RequestParam String password){
    	HttpSession session = request.getSession();
   	 // 获取当前本地语言
       Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
       Map<String,String> map = new HashMap<String,String>();
       ResponseResult result = new ResponseResult();
       if ("zh_CN".equals(locale.toString())) {
           map.put("msg1", "服务器异常,请稍后重试");
           map.put("msg2", "你还没有登录,请登录后重试");
           map.put("msg3", "用户账号不能为空");
           map.put("msg4", "登录密码不能为空");
       }
       if ("en_US".equals(locale.toString())) {
           map.put("msg1", "Server exception,please try again later.");
           map.put("msg2", "You haven't logged in yet,please login and try again");
           map.put("msg3", "The user account cannot be empty");
           map.put("msg4", "The login password cannot be empty");
       }
    	
    	
       
       result.setCode(ResultCode.FORM_INFO_ERROR);
       result.setData("");
       if (null == account || StringUtils.isBlank(account)) {
    	   result.setMessage(Toolkits.defaultString(map.get("msg3")));
    	   return result;
       }
       if (null == password || StringUtils.isBlank(password)) {
    	   result.setMessage(Toolkits.defaultString(map.get("msg4")));
    	   return result;
       }
       
       
       HashMap<String, String> hashMap = new HashMap<String, String>();
       hashMap.put("loginId", account);
       hashMap.put("password", password);
       
        try {
        	String json = userLoginService.resetPassword(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg1")));
			result.setData("");
			log.error("{} 重置登录密码 发生异常.",e.toString());
			return result;
		}
    }
    



}
