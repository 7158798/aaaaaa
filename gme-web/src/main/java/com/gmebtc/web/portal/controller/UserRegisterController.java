package com.gmebtc.web.portal.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.entity.User;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.UserRegisterService;
import com.gmebtc.web.portal.utils.Toolkits;

/**
 * @Author zhou
 * @Date 2018/5/26 10:01
 * @Desc 用户控制类
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class UserRegisterController {

	private static final Logger log = LoggerFactory.getLogger(UserRegisterController.class);

    @Resource(name = "userService")
    private UserRegisterService userService;



    /**
     * @Author zhou
     * @Date 2018/5/24 14:21
     * @Desc 手机号注册
     */
    @RequestMapping(value = "/phoneRegister",method = RequestMethod.POST)
    @ResponseBody
    public Object userPhoneRegister(HttpServletRequest request,User user) {

        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        ResponseResult result = new ResponseResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "手机号不能为空");
            map.put("msg2", "手机验证码不能为空");
            map.put("msg3", "登录密码不能为空");
            map.put("msg4", "资金密码不能为空");
            map.put("msg5", "手机号格式错误");
            map.put("msg6", "图片验证码不正确");
            map.put("msg7", "服务器异常,请稍后重试");
        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Cell phone number can not be empty");
            map.put("msg2","Cell phone verification code can not be empty");
            map.put("msg3", "The login password can not be empty");
            map.put("msg4", "Capital cipher can not be empty");
            map.put("msg5", "Cell phone number error");
            map.put("msg6", "Image verification code is incorrect");
            map.put("msg7", "Server exception,please try again later.");
        }

        result.setCode(ResultCode.FORM_INFO_ERROR);
        // 验证图片验证码是否正确
        String validateCode = (String) session.getAttribute(SessionAttributes.VALIDATE_CODE);
        if (null == validateCode || !user.getImgCode().equalsIgnoreCase(validateCode)) {
        	result.setMessage(Toolkits.defaultString(map.get("msg6")));
        	result.setData("");
        	return result;
        }
        // 手机号码是否为空
        if (null == user.getPhoneCode() || StringUtils.isBlank(user.getPhoneCode())) {
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (null == user.getPassword() || StringUtils.isBlank(user.getPassword())) {
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        if (null == user.getTradeAuth() || StringUtils.isBlank(user.getTradeAuth())) {
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isPhone(user.getPhoneCode())) {
            result.setMessage(Toolkits.defaultString(map.get("msg5")));
            result.setData("");
            return result;
        }
        // 手机验证码是否为空
        if (null == user.getIdentCode() || StringUtils.isBlank(user.getIdentCode())) {
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("phoneCode", user.getPhoneCode());
        hashMap.put("countryCode", user.getCountryCode());
        hashMap.put("identCode", user.getIdentCode());
        hashMap.put("password", user.getPassword());
        hashMap.put("tradeAuth", user.getTradeAuth());
        hashMap.put("refereeId", user.getRefereeId());

        try {
        	String json = userService.userPhoneRegister(request,hashMap);
        	return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg7")));
			result.setData("");
			return result;
		}
    }


    /**
     * @Author zhou
     * @Date 2018/5/28 11:38
     * @Param [user:用户邮箱注册的信息]
     * @Desc 用户邮箱注册
     */
    @RequestMapping(value = "/emailRegister",method = RequestMethod.POST)
    @ResponseBody
    public Object userEmailRegister(HttpServletRequest request,User user) {
        HttpSession session = request.getSession();
        // 获取当前本地语言
        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        Map<String,String> map = new HashMap<String,String>();
        ResponseResult result = new ResponseResult();
        if ("zh_CN".equals(locale.toString())) {
            map.put("msg1", "邮箱不能为空");
            map.put("msg2", "登录密码不能为空");
            map.put("msg3", "资金密码不能为空");
            map.put("msg4", "邮箱格式错误");
            map.put("msg5", "服务器异常,请稍后重试");
            map.put("msg6", "图片验证码不正确");

        }
        if ("en_US".equals(locale.toString())) {
            map.put("msg1", "Mailbox cannot be empty");
            map.put("msg2", "The login password can not be empty");
            map.put("msg3", "Capital cipher can not be empty");
            map.put("msg4", "Mailbox format error");
            map.put("msg5", "Server exception,please try again later.");
        }
        
        result.setCode(ResultCode.FORM_INFO_ERROR);
        
        String validateCode = (String) session.getAttribute(SessionAttributes.VALIDATE_CODE);
        if (null == validateCode || !user.getImgCode().equalsIgnoreCase(validateCode)) {
        	result.setMessage(Toolkits.defaultString(map.get("msg6")));
            result.setData("");
            return result;
        }
        if (null == user.getEmail() || StringUtils.isBlank(user.getEmail())) {
            result.setMessage(Toolkits.defaultString(map.get("msg1")));
            result.setData("");
            return result;
        }
        if (!Toolkits.isEmail(user.getEmail())) {
            result.setMessage(Toolkits.defaultString(map.get("msg4")));
            result.setData("");
            return result;
        }
        if (null == user.getPassword() || StringUtils.isBlank(user.getPassword())) {
            result.setMessage(Toolkits.defaultString(map.get("msg2")));
            result.setData("");
            return result;
        }
        if (null == user.getTradeAuth() || StringUtils.isBlank(user.getTradeAuth())) {
            result.setMessage(Toolkits.defaultString(map.get("msg3")));
            result.setData("");
            return result;
        }
        
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("email", user.getEmail());
        hashMap.put("password", user.getPassword());
        hashMap.put("tradeAuth", user.getTradeAuth());
        hashMap.put("refereeId", user.getRefereeId());

        try {
        	String json = userService.userEmaillRegister(request,hashMap);
        	return Toolkits.handleResp(json);
        } catch (Exception e) {
        	result.setCode(ResultCode.SYSTEM_ERROR);
        	result.setMessage(Toolkits.defaultString(map.get("msg5")));
        	result.setData("");
        	log.error("{} 邮箱注册发生异常.",e.toString());
        	return result;
		}
    }



}
