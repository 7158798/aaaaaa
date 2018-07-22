package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.UserRegisterService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;


/**
 * @Author zhou
 * @Date 2018/5/26 10:41
 * @Desc 用户基本信息service实现类
 */
@Service(value = "userService")
public class UserRegisterServiceImpl implements UserRegisterService{


    // 获得eolinker的基础参数
    
    

    /**
     * @Author zhou
     * @Date 2018/5/26 14:14
     * @Param [user:用户手机注册填写的信息, request]
     * @Desc 手机号注册
     */
    @Override
    public String userPhoneRegister(HttpServletRequest request,HashMap<String, String> hashMap) {
        String method = ConfigUtil.get("USER_PHONE_REGISTER");
        return SendRequestUtil.sendPojoRequest(request, hashMap, method);
    }


    /**
     * @Author zhou
     * @Date 2018/5/28 15:50
     * @Param [request, user]
     * @Desc 用户邮箱注册
     */
    @Override
    public String userEmaillRegister(HttpServletRequest request, HashMap<String, String> hashMap) {
        String method = ConfigUtil.get("USER_EMAIL_REGISTER");
        return SendRequestUtil.sendPojoRequest(request, hashMap, method);
    }


}
