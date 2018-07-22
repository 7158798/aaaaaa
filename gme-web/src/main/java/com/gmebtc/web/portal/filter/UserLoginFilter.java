package com.gmebtc.web.portal.filter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.utils.ResultCodeMessageUtil;
import com.gmebtc.web.portal.vo.UserVO;


/**
 * 
 * @Project：gme-web   
 * @Class：UserLoginFilter   
 * @Description 用户是否登录拦截器    
 * @Author：zhou   
 * @Date：2018年6月27日 下午10:00:33   
 * @version V1.0
 */
public class UserLoginFilter extends HandlerInterceptorAdapter{
	
	
	
	
	/**
	 * 
	 * @Title: preHandle
	 * @Description: TODO 在用户访问被拦截的controller前处理，主要判断用户是否有权限访问
	 * @param @param request
	 * @param @param response
	 * @param @param handler
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		 // 获取当前本地语言
//        Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
//        ResponseResult result = new ResponseResult();
        
		StringBuffer requestURL = request.getRequestURL();
		String suffix = requestURL.substring(requestURL.lastIndexOf(".") + 1,requestURL.length());
		
		// session是否有用户二步登录后的信息
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		// 没有登录，并且被拦截
		if (null == userVO) {
			// 后缀不是json的用户没有登录全部直接跳转到登录页面
			if (suffix != "json") {
				response.sendRedirect("http://192.168.136.1:8080/gme-web/firstLogin.html");
				return false;
			}else {
//				result.setCode(101);
//				result.setMessage(ResultCodeMessageUtil.getCodeMessage(101, locale.toString()));
//				result.setData("");
//				return false;
			}
		}
		
		
		
		
		
		return true;
		
	}

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	

}
