package com.gmebtc.web.portal.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmebtc.web.portal.service.SecurityConterService;
import com.gmebtc.web.portal.utils.ConfigUtil;
import com.gmebtc.web.portal.utils.SendRequestUtil;

/*
 * @Author zhou
 * @Date 2018/5/30 18:26
 * @Desc 安全中心
 */
@Service(value = "securityConterService")
public class SecurityConterServiceImpl implements SecurityConterService {



    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 20:05
     * @Param [request, hashMap]
     * @Desc 发生邮件
     */
    @Override
    public String sendEmail(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
       String method = ConfigUtil.get("SECURITY_SENDEMAIL");
       return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }

    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 20:21
     * @Param [request, hashMap]
     * @Desc 实名认证
     */
    @Override
    public String identifyAuth(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
       String method = ConfigUtil.get("SECURITY_IDENTIFYAUTH");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }



    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 20:48
     * @Param [request, hashMap]
     * @Desc 绑定银行卡
     */
    @Override
    public String payMethedBank(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("SECURITY_PAYMETHODBANK");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 21:01
     * @Param [request, hashMap]
     * @Desc 绑定支付宝或者微信
     */
    @Override
    public String payMethedAlipayWeChat(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("SECURITY_PAYMETHODALI");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


   /**
    * 
    * Title: checkUserIdentify
    * Description: 检查用户信息
    * @param request
    * @param hashMap
    * @return  
 * @throws Exception 
    * @see com.gmebtc.web.portal.service.SecurityConterService#checkUserIdentify(javax.servlet.http.HttpServletRequest, java.util.HashMap)
    */
    @Override
    public String checkUserIdentify(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("SECURITY_CHECKUSERIDENTIFY");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 21:25
     * @Param [request, hashMap]
     * @Desc 绑定手机号
     */
    @Override
    public String bindPhone(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("SECURITY_BINDPHONE");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/30 21:30
     * @Param [request, hashMap]
     * @Desc 绑定邮箱
     */
    @Override
    public String bindEmail(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("SECURITY_BINDEMAIL");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/31 20:57
     * @Param [request, hashMap]
     * @Desc 邮箱激活验证
     */
    @Override
    public String emailActiveCheck(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
    	 String method = ConfigUtil.get("SECURITY_ACTIVECHECK");
         return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }

    
    /**
     * @throws Exception 
     * @Author zhou
     * @Param [request, hashMap]
     * @Desc 验证邮箱验证码
     */
	public String checkEmailCode(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("SECURITY_CHECKEMAILCODE");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

	
	
	 /**
     * 
     * Title: resetPayPasswordFirst
     * Description: 修改资金密码第一步
     * @param request
     * @param hashMap
     * @return  
	 * @throws Exception 
     * @see com.gmebtc.web.portal.service.SecurityConterService#resetPayPasswordFirst(javax.servlet.http.HttpServletRequest, java.util.HashMap)
     */
    @Override
    public String resetPayPasswordFirst(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("SECURITY_RESETPAYPWDFIRST");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }
	
	
	/**
	 * 
	 * Title: resetPayPasswordSecond
	 * Description: 修改资金密码第
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.SecurityConterService#resetPayPasswordSecond(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String resetPayPasswordSecond(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("SECURITY_RESETPAYPWDSECOND");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}



	/**
	 * 
	 * Title: getSecurityLogList
	 * Description: 查询安全登录日志
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.SecurityConterService#getSecurityLogList(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String getSecurityLogList(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("ADMIN_LOGINLOG");
		//return SendRequestUtil.sendMapRequest(request, hashMap, method);
		return SendRequestUtil.sendRequest(request, method);
	}



	/**
	 * 
	 * Title: getSecurityOperationHistory
	 * Description: 查询操作日志
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.SecurityConterService#getSecurityOperationHistory(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String getSecurityOperationHistory(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("ADMIN_OPERATIONLOG");
		//return SendRequestUtil.sendMapRequest(request, hashMap, method);
		return SendRequestUtil.sendRequest(request, method);
	}

	
	 /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/28 18:09
     * @Param [request, user:短信验证码用户信息]
     * @Desc 发送短信验证码
     */
    @Override
    public String getMessageCode(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("USER_SENDSMSCODE");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }

    /**
     * @throws Exception 
     * @Author zhou
     * @Date 2018/5/28 18:34
     * @Param [request, user]
     * @Desc 验证验证码
     */
    @Override
    public String checkPhoneCode(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
        String method = ConfigUtil.get("USER_CHECKIDENTCODE");
        return SendRequestUtil.sendMapRequest(request, hashMap, method);
    }


	/**
	 * 
	 * Title: systemTime
	 * Description: 查询当前服务器时间
	 * @param request
	 * @param hashMap
	 * @return  
	 * @throws Exception 
	 * @see com.gmebtc.web.portal.service.SecurityConterService#systemTime(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String systemTime(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("aa");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

	
	/**
	 * 
	 * Title: openCloseTwoStep
	 * Description:TODO 开启或者关闭二步登录保护
	 * @param request
	 * @param hashMap
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.SecurityConterService#openCloseTwoStep(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String openCloseTwoStep(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("USER_OPENCLOSETWOSTEP");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

	
	/**
	 * 
	 * Title: openCloseWithdrawValidata
	 * Description:TODO 开启关闭提币双重认证
	 * @param request
	 * @param hashMap
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.SecurityConterService#openCloseWithdrawValidata(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String closeWithdrawValidata(HttpServletRequest request, HashMap<String, String> hashMap)
			throws Exception {
		String method = ConfigUtil.get("aa");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

	/**
	 * 
	 * Title: closePayMethod
	 * Description:TODO 关闭支付方式
	 * @param request
	 * @param hashMap
	 * @return
	 * @throws Exception  
	 * @see com.gmebtc.web.portal.service.SecurityConterService#closePayMethod(javax.servlet.http.HttpServletRequest, java.util.HashMap)
	 */
	@Override
	public String closePayMethod(HttpServletRequest request, HashMap<String, String> hashMap) throws Exception {
		String method = ConfigUtil.get("aa");
		return SendRequestUtil.sendMapRequest(request, hashMap, method);
	}

}
