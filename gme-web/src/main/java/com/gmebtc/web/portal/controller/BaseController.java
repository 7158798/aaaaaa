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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.entity.UserInfo;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.RechargeCoinService;
import com.gmebtc.web.portal.service.SecurityConterService;
import com.gmebtc.web.portal.service.WithdrawCoinService;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.BillVO;
import com.gmebtc.web.portal.vo.MyDeityVO;
import com.gmebtc.web.portal.vo.UserVO;

/*
 * @Author zhou
 * @Date 2018/6/4 19:50
 * @Desc 页面跳转
 */
@Controller
public class BaseController {

	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@Resource(name = "rechargeCoinService")
	private RechargeCoinService rechargeCoinService;
	@Resource(name = "withdrawCoinService")
	private WithdrawCoinService withdrawCoinService;
	@Resource(name = "securityConterService")
	private SecurityConterService securityConterService;
	

	/**
	 * 
	 * @Title: index
	 * @Description:主页
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	/**
	 * 
	 * @Title: unLoginInde
	 * @Description: 跳转到未登录主页
	 * @param model
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/unLoginIndex")
	public String unLoginInde(Model model) {
		model.addAttribute("flag", "false");
		return "unLoginIndex";
	}

	/**
	 * 
	 * @Title: login
	 * @Description: 跳转到第一步登录页面
	 * @param model
	 * @param redirect
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/firstLogin")
	public String login(Model model, String redirect) {
		model.addAttribute("redirect", redirect);
		return "firstLogin";
	}

	/**
	 * 
	 * @Title: secondLogin
	 * @Description: 跳转到第二步登录页面
	 * @param model
	 * @param redirect
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/secondLogin")
	public String secondLogin(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_FIRSTLOGIN_TEMP);
		// 检查用户是否已经第一次登录
		if (null == userVO) {
			model.addAttribute("sessionOver","请重新登录");
			return "firstLogin";
		}
		return "secondLogin";
	}

	/**
	 * 
	 * @Title: register
	 * @Description: 跳转到注册页面
	 * @param model
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("flag", "false");
		return "register";
	}

	/**
	 * 
	 * @Title: findPassword
	 * @Description: 重置密码页面
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/resetPassword")
	public String findPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 清除用户登录状态
		session.setAttribute(SessionAttributes.LOGIN_SECONDLOGIN, null);
		return "resetPassword";
	}
	
	
	/**
	 * 
	* @Title: resetPayPassword  
	* @Description: TODO 重置资金密码页面 
	* @param request
	* @return
	* @return String
	 */
	@RequestMapping(value = "/resetPayPassword")
	public String resetPayPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 清除用户登录状态
		session.setAttribute(SessionAttributes.LOGIN_SECONDLOGIN, null);
		
		return "security/resetPayPassword";
	}

	
	


	/**
	 * 
	 * @Title: accounts
	 * @Description: 跳转到我的账户页面
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/accounts")
	public String accounts(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#accounts");
		return "userInfo/accounts";
	}

	/**
	 * 
	 * @Title: commission
	 * @Description: 推广页面
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/commission")
	public String commission(HttpServletRequest request) {

		return "userInfo/commission";
	}
	
	
	/**
	 * 
	 * @Title: bill
	 * @Description: 账单明细页面
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/bill")
	public String bill(HttpServletRequest request, Model model, BillVO billVO) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#bill");
		return "userInfo/bill";
	}
	
	
	/**
	 * 
	 * @Title: myDeity
	 * @Description: 我的挂单
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/myDeity")
	public String myDeity(HttpServletRequest request, Model model, MyDeityVO myDeityVO) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#myDeity");
		return "userInfo/myDeity";
	}
	
	
	/**
	 * 
	 * @Title: transRecord
	 * @Description: 我的成交记录
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/transRecord", method = RequestMethod.GET)
	public String transRecord(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#transRecord");
		return "record/transRecord";
	}
	
	
	
	/**
	 * 
	 * @Title: c2cTrans
	 * @Description: c2c交易记录页面   见c2cTransRecordController
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/c2cTransRecord")
	public String c2cTransRecord(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#c2cTransRecord");
		return "record/c2cTransRecord";
	}
	
	
	/**
	 * 
	* @Title: c2cBusTransRecord  
	* @Description: TODO c2c商家成交记录 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/c2cBusTransRecord")
	public String c2cBusTransRecord(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#c2cBusTransRecord");
		return "record/c2cBusTransRecord";
	}

	
	
	/**
	 * 
	 * @Title: rechargeRecord
	 * @Description: 充值记录页面
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/rechargeRecord")
	public String rechargeRecord(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#rechargeRecord");
		return "record/rechargeRecord";
	}


	
	/**
	 * 
	 * @Title: withdrawRecord
	 * @Description: 查询提现记录
	 * @param request
	 * @param model
	 * @param currencyId
	 * @param pageNum
	 * @param numPerPage
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/withdrawRecord")
	public String withdrawRecord(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#withdrawRecord");
		return "record/withdrawRecord";
	}
	

	/**
	 * 
	 * @Title: walletAddress
	 * @Description: 钱包地址管理
	 * @param request
	 * @param model
	 * @param currencyIdList
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/walletAddressManager")
	public String walletAddressManager(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		model.addAttribute("pageFlag","#walletAddressManager");
		return "wallet/walletAddressManager";
	}
	
	
	/**
	 * 
	* @Title: USDTWithdraw  
	* @Description: usdt提现页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/USDTWithdraw",method = RequestMethod.GET)
	public String USDTWithdraw (HttpServletRequest request,Model model,String symbol) {
		HttpSession session = request.getSession();
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		// 没有实名认证
		if (null == auth) {
			model.addAttribute("pageFlag","#realNameAuth");
			return "security/realNameAuth";
		}
			
		model.addAttribute("symbol",symbol);
		return "wallet/USDTWithdraw";
	}
	
	
	/**
	 * 
	* @Title: recharge  
	* @Description: usdt充值 
	* @param model
	* @return
	* @return String
	 */
	@RequestMapping(value = "/recharge",method = RequestMethod.GET)
	public String recharge (Model model,String symbol) {
		model.addAttribute("symbol",symbol);
		return "wallet/recharge";
	}
	
	
	
	
	//************************************************C2C交易，币币交易**************************

	/**
	 * 
	 * @Title: c2cTransRecord
	 * @Description: c2c交易页面
	 * @param request
	 * @return
	 * @return String
	 */
	@RequestMapping(value = "/c2cTrans")
	public String c2cTrans(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String isBus = (String) session.getAttribute(SessionAttributes.USER_ISBUSINESS);
		if (null != isBus) {
			model.addAttribute("isBus","true");
		}
		return "transaction/c2cTrans";
	}

	
	
	/**
	 * 
	* @Title: bbTrans  
	* @Description: 币币交易页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/bbTrans",method = RequestMethod.GET)
	public String bbTrans (Model model,String symbol,String pairId) {
		if (null == symbol) {
			if (null == pairId) {
				model.addAttribute("pairSymbol","BTC_USDT");
				model.addAttribute("symbol","BTC");
				//model.addAttribute("symbolToken","USDT");
				//model.addAttribute("pairId","BTC_USDT的交易对id");
				model.addAttribute("pairId","22222");
			}
		}else {
			model.addAttribute("pairSymbol",symbol);
			model.addAttribute("symbol",symbol.split("_")[0]);
			//model.addAttribute("symbolToken",symbol.split("_")[1]);
			model.addAttribute("pairId",pairId);
		}
		return "transaction/bbTrans";
	}
	
	//=====================================================================C2C交易，币币交易===========================
	
	
	
	
	
	/** ===================================================================安全相关==============================*/
	
	/**
	 * 
	* @Title: securityLog  
	* @Description: 安全日志页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/securityLog",method = RequestMethod.GET)
	public String securityLog (HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		
		model.addAttribute("pageFlag","#securityLog");
		return "security/securityLog";
	}
	
	
	
	/**
	 * 
	* @Title: paySetting  
	* @Description: 支付设置 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/paySetting",method = RequestMethod.GET)
	public String paySetting (HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		
		// 测试先关闭
		/*if (null == auth) {
			model.addAttribute("pageFlag","#realNameAuth");
			return "security/realNameAuth";
		}*/
		
		UserInfo userInfo = (UserInfo) session.getAttribute(SessionAttributes.USER_INFO);
		String bankcard = (String) session.getAttribute(SessionAttributes.USER_ISBINDBANKCARD);
		String alipay = (String) session.getAttribute(SessionAttributes.USER_ISBINDALIPAY);
		String wechat = (String) session.getAttribute(SessionAttributes.USER_ISBINDWECHAT);
		if (null != bankcard) {
			model.addAttribute("bankcard","true");
			model.addAttribute("bank", userInfo.getPayMethod().getBank());
			model.addAttribute("name", userInfo.getPayMethod().getName());
			model.addAttribute("branch", userInfo.getPayMethod().getBranch());
			model.addAttribute("bankCardNum", userInfo.getPayMethod().getBankCard());
			
		}
		if (null != alipay) {
			model.addAttribute("alipay","true");
			model.addAttribute("aliPayImgUrl", userInfo.getPayMethod().getAlipayImg());
			model.addAttribute("aliPayNum", userInfo.getPayMethod().getAlipayAccount());
			model.addAttribute("aliPayremark", userInfo.getPayMethod().getAlipayDesc());
		}
		if (null != wechat) {
			model.addAttribute("wechat", "true");
			model.addAttribute("wechatImgUrl", userInfo.getPayMethod().getWechatImg());
			model.addAttribute("wechatNum", userInfo.getPayMethod().getWechatAccount());
			model.addAttribute("wechatremark", userInfo.getPayMethod().getWechatDesc());
		}
		
		model.addAttribute("pageFlag","#paySetting");
		return "security/paySetting";
	}
	
	
	/**
	 * 
	* @Title: withdrawDoubleValida  
	* @Description: 提币双重认证 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/withdrawDoubleValida",method = RequestMethod.GET)
	public String withdrawDoubleValida (HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		
		UserInfo userInfo = (UserInfo) session.getAttribute(SessionAttributes.USER_INFO);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String withdrawPhone = (String) session.getAttribute(SessionAttributes.USER_ISWITHDRAWPHONE);
		String withdrawEmail = (String) session.getAttribute(SessionAttributes.USER_ISWITHDRAWEMAIL);
		String phoneNum = userInfo.getPhone();
		String email = userInfo.getEmail();
		// 绑定手机
		if (null != bindPhone) {
			model.addAttribute("phoneCode", phoneNum.substring(phoneNum.length()-2, phoneNum.length()));
		}
		// 绑定邮箱
		if (null != email && !StringUtils.isBlank(email)) {
			model.addAttribute("email",email);
		}
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		
		// 是否开启了手机提币验证
		if (null != withdrawPhone) {
			model.addAttribute("isOpenPhone","true");
		}
		// 是否开启了邮箱提币验证
		if (null != withdrawEmail) {
			model.addAttribute("isOpenEmail","true");
		}
		
		// 测试，暂时关闭
		/*if (null == auth) {
			model.addAttribute("pageFlag","#realNameAuth");
			return "security/realNameAuth";
		}*/
		
		
		model.addAttribute("pageFlag","#withdrawDoubleValida");
		return "security/withdrawDoubleValida";
	}
	
	
	/**
	 * 
	* @Title: bindEmail  
	* @Description: 邮箱绑定 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/bindEmail",method = RequestMethod.GET)
	public String bindEmail (HttpServletRequest request,Model model) {
		// 检查用户信息,是否绑定手机号
		HttpSession session = request.getSession();
		
		UserInfo userInfo = (UserInfo) session.getAttribute(SessionAttributes.USER_INFO);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String bindEmail = (String) session.getAttribute(SessionAttributes.USER_ISBINDEMAIL);
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		model.addAttribute("pageFlag","#bindEmail");
		if (null != bindEmail) {
			model.addAttribute("bindEmail",userInfo.getEmail());
		}
		return "security/bindEmail";
	}
	
	
	/**
	 * 
	* @Title: api  
	* @Description: api页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/api",method = RequestMethod.GET)
	public String api () {
		return "security/api";
	}
	
	
	/**
	 * 
	* @Title: secondLoginProtect  
	* @Description: 二步登录保护页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/secondLoginProtect",method = RequestMethod.GET)
	public String secondLoginProtect (HttpServletRequest request,Model model) {
		
		HttpSession session = request.getSession();
		
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String twoStep = (String) session.getAttribute(SessionAttributes.USER_ISTWOSTEP);
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		model.addAttribute("pageFlag","#secondLoginProtect");
		if (null != twoStep) {
			model.addAttribute("twoStep","true");
		}
		
		return "security/secondLoginProtect";
	}
	
	
	/**
	 * 
	* @Title: bindPhone  
	* @Description: 手机绑定 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/bindPhone",method = RequestMethod.GET)
	public String bindPhone (HttpServletRequest request,Model model) {
		// 检查用户信息,是否绑定手机号
		HttpSession session = request.getSession();

		UserInfo userInfo = (UserInfo) session.getAttribute(SessionAttributes.USER_INFO);
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		model.addAttribute("pageFlag","#bindPhone");
		if (null != bindPhone) {
			// 存手机尾号
			String phoneNum = userInfo.getPhone();
			model.addAttribute("bindPhone", phoneNum.substring(phoneNum.length()-2, phoneNum.length()));
		}
		return "security/bindPhone";
		
	}
	
	
	/**
	 * 
	* @Title: realNameAuth  
	* @Description: 实名认证 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/realNameAuth",method = RequestMethod.GET)
	public String realNameAuth (HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String bindPhone = (String) session.getAttribute(SessionAttributes.USER_ISBINDPHONE);
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		String authStaus = (String) session.getAttribute(SessionAttributes.USER_ISAUTHSTATUS);
		// 没有绑定手机
		if (null == bindPhone) {
			model.addAttribute("pageFlag","#bindPhone");
			return "security/bindPhone";
		}
		model.addAttribute("pageFlag","#realNameAuth");
		if (authStaus == "1") {
			model.addAttribute("isAuthStatus","1");
		}else if (authStaus == "2") {
			model.addAttribute("isAuthStatus","2");
		}else if (authStaus == "3") {
			model.addAttribute("isAuthStatus","3");
		}else if (authStaus == "4") {
			model.addAttribute("isAuthStatus","4");
			model.addAttribute("authFailMsg",session.getAttribute(SessionAttributes.USER_ISAUTHFAILMESSAGE));
		}
		
		return "security/realNameAuth";
		
	}
	
	
	
	
	
	
	/** ===================================公告相关================================================*/
	
	
	
	/**
	 * 
	* @Title: notice  
	* @Description: 公告页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/notice",method = RequestMethod.GET)
	public String notice () {
		return "other/notice";
	}
	
	/**
	 * 
	* @Title: noticeDetail  
	* @Description: 公告详情页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/noticeDetail",method = RequestMethod.GET)
	public String noticeDetail (Model model,@RequestParam String noticeId) {
		 model.addAttribute("noticeId",noticeId);
		return "other/noticeDetail";
	}
	

	
	/**
	 * 
	* @Title: currencyDetail  
	* @Description: 币种详情页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/currencyDetail",method = RequestMethod.GET)
	public String currencyDetail () {
		return "other/currencyDetail";
	}
	
	
	/**=============================================工单页面==========================*/
	
	
	/**
	 * 
	* @Title: myWorkList  
	* @Description: 提交工单页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/myWorkList",method = RequestMethod.GET)
	public String myWorkList (HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String auth = (String) session.getAttribute(SessionAttributes.USER_ISAUTH);
		if (null != auth) {
			model.addAttribute("isAuth","true");
		}
		return "userInfo/myWorkList";
	}
	
	
	/**
	 * 
	* @Title: workListDetail  
	* @Description: 工单详情页面 
	* @return
	* @return String
	 */
	@RequestMapping(value = "/workListDetail",method = RequestMethod.GET)
	public String workListDetail (Model model,@RequestParam String subjectId) {
		model.addAttribute("subjectId", subjectId);
		
		return "userInfo/workListDetail";
	}
	
	
	
	/**
	 * 
	* @Title: emailActiveCheck  
	* @Description: TODO  邮箱激活验证
	* @param request
	* @param token
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/emailActiveCheck", method = RequestMethod.GET)
	public String emailActiveCheck(HttpServletRequest request, Model model,String token) {
		HttpSession session = request.getSession();
		Locale locale = (Locale) session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		HashMap<String, String> map = new HashMap<>();
		ResponseResult result = new ResponseResult();
		if ("zh_CN".equals(locale.toString())) {
			map.put("msg1", "服务器异常,请稍后重试");
			map.put("msg2", "激活邮箱失败，请重新注册");
		}
		if ("en_US".equals(locale.toString())) {
			map.put("msg1", "Server exception,please try again later");
			map.put("msg2", "Failed to activate mailbox,Please register again");
		}
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("activeId", token);
		
		try {
			String json = securityConterService.emailActiveCheck(request, hashMap);
			result = Toolkits.handleResp(json);
			// 激活成功后跳转登录页面
			if (result.getCode().equals("200")) {
				return "firstLogin";
			}else {
				// 激活不成功跳转注册页面
				model.addAttribute("activeFailed",Toolkits.defaultString(map.get("msg2")));
				return "register";
			}
		} catch (Exception e) {
			result.setCode(ResultCode.SYSTEM_ERROR);
			result.setMessage(Toolkits.defaultString(map.get("msg1")));
			result.setData("");
			log.error("{} 激活邮箱发生异常", e.toString());
			return "";
		}
	}

	
	

	/**
	 * 国际化转换
	 *
	 * @param session
	 * @param request
	 * @param lang
	 */
	@RequestMapping(value = "/changeLang")
	@ResponseBody
	public Object changeLang(HttpSession session, HttpServletRequest request, @RequestParam String lang) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Locale locale = null;
		if (lang.equals("zh_CN")) {
			locale = new Locale("zh", "CN");
		} else if (lang.equals("en_US")) {
			locale = new Locale("en", "US");
		}

		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		session.setAttribute("locale", locale.toString());
		map.put("locale", locale.toString());

		return map;
	}
}
