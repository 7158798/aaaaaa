package com.gmebtc.web.portal.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
import com.gmebtc.web.portal.service.MessageCodeService;
import com.gmebtc.web.portal.utils.RegexUtil;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.UserVO;

/*
 * @Author zhou
 * @Date 2018/5/28 16:28
 * @Desc 短信验证码控制类
 */
@Controller
@RequestMapping(value = "${ROOT_PATH}/user")
public class MessageCodeController {
	private static final Logger log = LoggerFactory.getLogger(MessageCodeController.class);

	@Resource(name = "messageCodeService")
	private MessageCodeService messageCodeService;

	
	/**
	 * 
	* @Title: getMessageCode  
	* @Description: 发送短信验证码 
	* @param request
	* @param user
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/sendPhoneCheckCode", method = RequestMethod.POST)
	public Object getMessageCode(HttpServletRequest request, User user) {
		HttpSession session = request.getSession();
		// 获取当前本地语言
		Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		Map<String, String> map = new HashMap<String, String>();
		ResponseResult result = new ResponseResult();
		if ("zh_CN".equals(locale.toString())) {
			map.put("msg1", "手机号格式错误");
			map.put("msg2", "服务器异常,请稍后重试");
		}
		if ("en_US".equals(locale.toString())) {
			map.put("msg1", "Cell phone number error");
			map.put("msg2", "Server exception,please try again later.");
		}

		
		
		result.setCode(ResultCode.FORM_INFO_ERROR);
		result.setData("");
		
		if (null != user.getPhoneCode() && !RegexUtil.isPhoneNumber(user.getPhoneCode())) {
			result.setMessage(Toolkits.defaultString(map.get("msg2")));
			return result;
		}
		
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		/*try {
			UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_FIRSTLOGIN);
			// 如果是 登录二次验证发送短信验证码,需要传uid给后台
			if (user.getType().equals("2")) {
				hashMap.put("uid", userVO.getUid());
			}
		} catch (Exception e) {
			result.setCode(ResultCode.WEB_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg1")));
			result.setData("");
			return result;
		}*/
		
		// 注册时，不需要用户id
		if (user.getType() != "1") {
			hashMap.put("uid", "91f9cfcf-7a95-11e8-ad83-4ccc6ad6addc");
		}
		if (null != user.getCountryCode()) {
			hashMap.put("countryCode", user.getCountryCode());
		}
		if (null != user.getSendByVoice()) {
			hashMap.put("sendByVoice", user.getSendByVoice());
		}
		if (null != user.getPhoneCode()) {
			hashMap.put("phoneCode", user.getPhoneCode());
		}
		
		hashMap.put("type", user.getType());

		
		try {
			String json = messageCodeService.getMessageCode(request, hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg2")));
			result.setData("");
			log.error("{} 发送短信验证码 解析后台数据出错", e.toString());
			return result;
		}
	}

	/**
	 * @Author zhou
	 * @Date 2018/5/31 9:54
	 * @Param [request, user]
	 * @Desc 验证短信验证码
	 */
	@RequestMapping(value = "/checkIdentCode", method = RequestMethod.POST)
	@ResponseBody
	public Object checkIdentCode(HttpServletRequest request, User user) {
		HttpSession session = request.getSession();
		// 获取当前本地语言
		Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		Map<String, String> map = new HashMap<String, String>();
		ResponseResult result = new ResponseResult();
		if ("zh_CN".equals(locale.toString())) {
			map.put("msg1", "手机号码不能为空");
			map.put("msg2", "手机号码格式不正确");
			map.put("msg3", "短信验证码不能为空");
			map.put("msg4", "服务器异常,请稍后重试");
			map.put("msg5", "你还没有登录,请登录后重试");
		}
		if ("en_US".equals(locale.toString())) {
			map.put("msg1", "Cell phone Numbers should not be empty");
			map.put("msg2", "The phone number format is incorrect");
			map.put("msg3", "SMS verification code cannot be empty");
			map.put("msg4", "Server exception,please try again later");
			map.put("msg5", "You haven't logged in yet,please login and try again");
		}

		result.setCode(ResultCode.FORM_INFO_ERROR);
		UserVO userVO = new UserVO();
		

		if (null != user.getType()) {
			// 如果当前验证类型是 重置登录密码验证短信验证码
			if (user.getType().equals("3")) {
				
			}else {
				// 判断用户是否登录，如果未登录，提示请登录
				userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				if (null == userVO) {
					result.setMessage(Toolkits.defaultString(map.get("msg5")));
					result.setData("");
					return result;
				}
			}
		}

		// 如果是登录二次验证，前端页面不需要手机号
		/*
		 * if (null == user.getType() || !user.getType().equals("3")) { if (null ==
		 * user.getPhoneCode() || StringUtils.isBlank(user.getPhoneCode())) {
		 * result.setMessage(Toolkits.defaultString(map.get("msg1")));
		 * result.setData(""); return result; } if
		 * (!Toolkits.isPhone(user.getPhoneCode())) {
		 * result.setMessage(Toolkits.defaultString(map.get("msg2")));
		 * result.setData(""); return result; } }
		 * 
		 * if (null == user.getIdentCode() || StringUtils.isBlank(user.getIdentCode()))
		 * { result.setMessage(Toolkits.defaultString(map.get("msg3")));
		 * result.setData(""); return result; }
		 */

		session.setAttribute(SessionAttributes.USER_LOGINID, "afda");

		// 测试数据，
		result.setCode(ResultCode.SUCCESS);
		result.setMessage(Toolkits.defaultString(map.get("成功")));
		result.setData("");
		return result;

		/*
		 * HashMap<String, String> hashMap = new HashMap<String, String>();
		 * hashMap.put("phoneCode", user.getPhoneCode()); hashMap.put("identCode",
		 * user.getIdentCode()); hashMap.put("type", user.getType()); hashMap.put("uid",
		 * userVO.getUid()); try { String json =
		 * messageCodeService.checkPhoneCode(request,hashMap); result = (ResponseResult)
		 * Toolkits.fromJsonToPojo(json, ResponseResult.class); // 成功验证短信验证码 if (null !=
		 * result && result.getCode().equals(ResultCode.SUCCESS)) { // 如果是 找回登陆密码
		 * 短信验证码，需要存用户的账号，给第二个页面确认找回使用 if (user.getType().equals("3")){
		 * session.setAttribute(SessionAttributes.USER_LOGINID, user.getPhoneCode());
		 * return result; } } return Toolkits.handleResp(json); } catch (Exception e) {
		 * result.setCode(ResultCode.SYSTEM_ERROR);
		 * result.setMessage(Toolkits.defaultString(map.get("msg4")));
		 * result.setData(""); log.error("{} 验证短信验证码发送异常.",e.toString()); return result;
		 * }
		 */
	}

}
