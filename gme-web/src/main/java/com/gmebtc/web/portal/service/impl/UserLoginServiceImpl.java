package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.UserLoginService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/**
 * 
 * @Project：gme-web   
 * @Class：UserLoginServiceImpl   
 * @Description 类描述：用户登录,忘记登录密码,注销登录 服务类     
 * @Author：zzh 
 * @Date：2018年6月29日 下午3:44:57   
 * @version v1.0
 */
@Service(value = "userLoginService")
public class UserLoginServiceImpl implements UserLoginService {


	/**
	 * 
	 * Title: login
	 * Description: 用户登录
	 * @param request
	 * @param hashMap
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.UserLoginService#login(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
    @Override
    public String login(HttpServletRequest request, HashMap<String, Object> hashMap) throws Exception{
        String method = ConfigUtil.get("USER_LOGIN");
        return SendRequestUtil.sendMapRequest(request, hashMap,method);
    }


    /**
     * 
     * Title: logout
     * Description: 用户登出
     * @param request
     * @param hashMap
     * @return
     * @throws Exception  
     * @see com.gmebtc.web.portal.service.UserLoginService#logout(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String logout(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception{
        String method = ConfigUtil.get("USER_LOGOUT");
        return SendRequestUtil.sendMapRequest(request,hashMap,method);
    }

    /**
     * 
     * Title: resetPassword
     * Description: 重置登录密码
     * @param request
     * @param hashMap
     * @return
     * @throws Exception  
     * @see com.gmebtc.web.portal.service.UserLoginService#resetPassword(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String resetPassword(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception{
        String method = ConfigUtil.get("USER_RESETPASSWORD");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }






    /**
     * @Author zhou
     * @Date 2018/5/31 10:22
     * @Param [request, hashMap]
     * @Desc 获取图像验证码
     */
    /* @Override
    public void getImgCode(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> hashMap) {
        String method = ConfigUtil.getURL("DOMAIN_DING", "USER_LOGIN");
        try {
            byte[] isb = HttpClientUtil.doGetForImageCode(method, hashMap);
            ServletOutputStream sos = response.getOutputStream();
            sos.write(isb);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


}
