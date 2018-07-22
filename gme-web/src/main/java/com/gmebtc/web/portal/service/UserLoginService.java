package com.gmebtc.web.portal.service;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface UserLoginService {

	/**
	 * 
	* @Title: login  
	* @Description: 用户登录 
	* @param request
	* @param hashMap
	* @return
	* @throws Exception
	* @return String
	 */
    String login(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception;
    /**
     * 
    * @Title: logout  
    * @Description: 用户登出 
    * @param request
    * @param hashMap
    * @return
    * @throws Exception
    * @return String
     */
    String logout (HttpServletRequest request,HashMap<String, String> hashMap) throws Exception;
    /**
     * 
    * @Title: resetPassword  
    * @Description: 重置登录密码 
    * @param request
    * @param hashMap
    * @return
    * @throws Exception
    * @return String
     */
    String resetPassword(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception;

    //void getImgCode(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> hashMap);
}
