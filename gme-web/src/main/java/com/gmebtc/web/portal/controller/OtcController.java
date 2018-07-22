package com.gmebtc.web.portal.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;

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

import com.gmebtc.web.portal.constant.Constants;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.entity.BusOTCOrder;
import com.gmebtc.web.portal.entity.UserInfo;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.OtcService;
import com.gmebtc.web.portal.service.SecurityConterService;
import com.gmebtc.web.portal.utils.ResultCodeMessageUtil;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.C2CTransRecordVO;
import com.gmebtc.web.portal.vo.UserVO;

/**
 * 
 * @Project：gme-web
 * @Class：OtcController
 * @Description 类描述：c2c相关
 * @Author：zzh
 * @Date：2018年7月6日 下午8:52:45
 * @version v1.0
 */
@RestController
@RequestMapping("${ROOT_PATH}/otc")
public class OtcController {

	private static final Logger log = LoggerFactory.getLogger(OtcController.class);

	@Resource(name = "otcService")
	private OtcService otcService;
	@Resource(name = "securityConterService")
	private SecurityConterService securityConterService;

	/**
	 * 
	 * @Title: checkPayMethod
	 * @Description: 检查是否选择支付方式
	 * @param payMehtod
	 * @return
	 * @return boolean
	 */
	private static boolean checkPayMethod(String payMehtod) {
		StringBuffer methodStr = new StringBuffer(payMehtod);

		if (methodStr.length() != 6) {
			return false;
		} else {
			if ((methodStr.indexOf("1") == -1) && (methodStr.indexOf("2") == -1)) {
				return false;
			}
			if (methodStr.indexOf("1") != -1) {
				int zeroIndex = methodStr.indexOf("1") - 1;
				if (zeroIndex < 0 || methodStr.charAt(zeroIndex) != '0') {
					return false;
				}
			}
			if (methodStr.indexOf("2") != -1) {
				int zeroIndex = methodStr.indexOf("2") - 1;
				if (zeroIndex < 0 || methodStr.charAt(zeroIndex) != '0') {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	/**
	 * 
	 * @Title: checkUserInfo
	 * @Description:  检查用户信息
	 * @param isCheckLogin 是否检查是否登录
	 * @param isCheckAuth  是否检查是否实名认证
	 * @param isCheckBindPhone 是否检查是否绑定手机
	 * @param isBusiness       是否检查是否是商家
	 * @param isCheckBank      是否检查是绑定银行卡是否正确  
	 * @param isCheckAli       是否检查绑定支付宝是否正确  
	 * @param isCheckWechat    是否检查绑定微信是否正确   
	 * @return  
	 * @return Object
	 */
	public Object checkUserInfo (HttpServletRequest request,boolean isCheckLogin,boolean isCheckAuth,boolean isCheckBindPhone
								,boolean isCheckBusiness,boolean isCheckBank,boolean isCheckAli,boolean isCheckWechat ) {
		HttpSession session = request.getSession();
		ResponseResult result = new ResponseResult();
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		// 检查是否登录
		if (isCheckLogin) {
			if (null == userVO) {
				result.setCode(ResultCodeMessageUtil.MsgCode101);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode101, request));
				return result;
			}
		}
		try {
			HashMap<String, String> hashMap = new HashMap<String, String>();
			hashMap.put("uid", userVO.getUid());
			// 取用户信息
			String securityJson = securityConterService.checkUserIdentify(request, hashMap);
			result = Toolkits.handleResp(securityJson);
			UserInfo userInfo = (UserInfo) Toolkits.fromJsonToPojo(Toolkits.fromPojotoJson(result.getData()), UserInfo.class);
			// 检查是否实名认证
			if (isCheckAuth) {
				if (userInfo.getIsIdentityAuthApply() == 0) {
					result.setCode(ResultCodeMessageUtil.MsgCode104);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode104, request));
					return result;
				}
			}
			// 检查是否绑定手机
			if (isCheckBindPhone) {
				if (userInfo.getIsBindPhone() == 0) {
					result.setCode(ResultCodeMessageUtil.MsgCode103);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode103, request));
					return result;
				}
			}
			// 检查是否是商家
			if (isCheckBusiness) {
				if (userInfo.getIsBusiness() == 0) {
					result.setCode(ResultCodeMessageUtil.MsgCode105);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode105, request));
					return result;
				}
			}
			// 检查是否绑定了银行卡
			if (isCheckBank) {
				if (userInfo.getIsBankCard() == 0) {
					result.setCode(ResultCodeMessageUtil.MsgCode106);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode106, request));
					return result;
				}
			}
			// 检查是否绑定了支付宝
			if (isCheckAli) {
				if (userInfo.getIsAlipay() == 0) {
					result.setCode(ResultCodeMessageUtil.MsgCode107);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode107, request));
					return result;
				}
			}
			// 检查是否绑定了微信
			if (isCheckWechat) {
				if (userInfo.getIsWechat() == 0) {
					result.setCode(ResultCodeMessageUtil.MsgCode108);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode108, request));
					return result;
				}
			}
		} catch (Exception e) {
			result.setCode(ResultCodeMessageUtil.MsgCode100);
			result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
			log.error("{} 检查用户信息 解析后台数据发生异常", OtcController.class + ":" + e.toString());
			return result;
		}
		
		return null;
	}
	
	
	

	/**
	 * 
	 * @Title: busBuyAndSellOrder
	 * @Description: 商家买卖usdt
	 * @param request
	 * @param busOTCOrder
	 * @return
	 * @return Object
	 */
	@RequestMapping(value = "/busBuyAndSell", method = RequestMethod.POST)
	public Object busBuyAndSellOrder(HttpServletRequest request, BusOTCOrder busOTCOrder) {
		HttpSession session = request.getSession();
		ResponseResult result = new ResponseResult();
		
		UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
		boolean isCheckBank = false;
		boolean isCheckPhone = false;
		boolean isCheckWechat = false;
		if (!OtcController.checkPayMethod(busOTCOrder.getPayMethod())) {
			StringBuffer payMethod = new StringBuffer(busOTCOrder.getPayMethod());
			if (payMethod.substring(0,2) == "01") {
				isCheckBank = true;
			}
			if (payMethod.substring(2,4) == "01") {
				isCheckPhone = true;
			}
			if (payMethod.substring(4,6) == "01") {
				isCheckWechat = true;
			}
		}else {
			result.setCode(ResultCodeMessageUtil.MsgCode102);
			result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode102, request));
			return result;
		}
		
		
		
		// 检查用户信息正确
		if (checkUserInfo(request,true,true,true,true,isCheckBank,isCheckPhone,isCheckWechat) == null) {
			// 验证数据是否完整
			if (Toolkits.isBlank(userVO,busOTCOrder.getPrice(),busOTCOrder.getNumber(),
						busOTCOrder.getMinMoney(),busOTCOrder.getMaxMoney(),
						busOTCOrder.getPayMethod())) {
				result.setCode(ResultCodeMessageUtil.MsgCode102);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode102, request));
				return result;
			}
			
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("uid", userVO.getUid());
			dataMap.put("currencyId", Constants.USDT_CurrencyId);
			dataMap.put("number", busOTCOrder.getNumber());
			dataMap.put("minMoney", busOTCOrder.getMinMoney());
			dataMap.put("maxMoney", busOTCOrder.getMaxMoney());
			dataMap.put("price", busOTCOrder.getPrice());
			dataMap.put("payMethod", busOTCOrder.getPayMethod());
			dataMap.put("type", busOTCOrder.getType());
			
			try {
				String json = otcService.busBuyAndSell(request, dataMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 商家买卖usdt 解析后台数据发生异常", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request,true,true,true,true,true,true,true);
		}
		

	}

	/**
	 * 
	 * @Title: getDeityList
	 * @Description: 查询所有商家挂单
	 * @param request
	 * @param type    1 购买 2 出售
	 * @return
	 * @return Object
	 */
	@RequestMapping(value = "/deityList", method = RequestMethod.GET)
	public Object getDeityList(HttpServletRequest request, String type) {
		ResponseResult result = new ResponseResult();

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("symbol", Constants.USDT_Symbol);
		hashMap.put("pageCount",Constants.USDT_PageCount);
		hashMap.put("type", type);

		try {
			String json = otcService.getDeityList(request, hashMap);
			return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCodeMessageUtil.MsgCode100);
			result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
			log.error("{} 查询所有商家挂单 解析后台数据发生异常.", e.toString());
			return result;
		}
	}

	
	/**
	 * 
	* @Title: getDeityList  
	* @Description: 查询我的商家订单 
	* @param request
	* @param symbol
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/busOrderList", method = RequestMethod.GET)
	public Object getBusOrderList(HttpServletRequest request, String symbol) {
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, true, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("symbol", Constants.USDT_Symbol);
				hashMap.put("pageCount", Constants.USDT_PageCount);
				hashMap.put("uid", userVO.getUid());
				String json = otcService.getDeityList(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 查询我的商家挂单 解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, true, false, false, false);
		}
	}

	
	
	
	/**
	 * 
	* @Title: c2cUserOrderHistory  
	* @Description:  c2c用户订单分页查询  
	* @param request
	* @param c2cTransRecordVO
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/userOrderHistory", method = RequestMethod.GET)
	public Object c2cUserOrderHistory(HttpServletRequest request, C2CTransRecordVO c2cTransRecordVO,
								@RequestParam(defaultValue="1") String pageNum,@RequestParam(defaultValue="10") String numPerPage) {
		HttpSession session = request.getSession();
		
		if (checkUserInfo(request, true, true, true, false, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if (null != c2cTransRecordVO.getStartTime() && !StringUtils.isBlank(c2cTransRecordVO.getStartTime())) {
						Long startTime = simple.parse(c2cTransRecordVO.getStartTime()).getTime();
						hashMap.put("startTime", startTime);
					}
					if (null != c2cTransRecordVO.getEndTime() && !StringUtils.isBlank(c2cTransRecordVO.getEndTime())) {
						Long endTime = simple.parse(c2cTransRecordVO.getEndTime()).getTime();
						hashMap.put("endTime", endTime);
					}
				} catch (Exception e) {
					log.error("{} c2c用户订单分页查询  页面时间转换失败");
				}
				
				if (null != c2cTransRecordVO.getSymbol()) {
					hashMap.put("symbol", c2cTransRecordVO.getSymbol());
				}
				if (null != c2cTransRecordVO.getType()) {
					hashMap.put("type", c2cTransRecordVO.getType());
				}
				if (null != c2cTransRecordVO.getStatus()) {
					hashMap.put("status", c2cTransRecordVO.getStatus());
				}
				
				hashMap.put("pageNum", pageNum);
				hashMap.put("numPerPage", numPerPage);
				hashMap.put("uid", userVO.getUid());
				
				String json = otcService.c2cUserOrderHistory(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} c2c用户订单分页查询   解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, false, false, false, false);
		}

	}
	
	
	
	/**
	 * 
	* @Title: busCancleOrder  
	* @Description: c2c商家取消订单 
	* @param request
	* @param payMethod
	* @param orderId
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/busCancleOrder", method = RequestMethod.POST)
	public Object busCancleOrder(HttpServletRequest request, @RequestParam String payMethod,@RequestParam String orderId) {
		
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, true, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("payMethod", payMethod);
				hashMap.put("orderId", orderId);
				hashMap.put("uid", userVO.getUid());
				String json = otcService.busCancleOrder(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} c2c商家取消订单  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, true, false, false, false);
		}
	}
	
	
	
	/**
	 * 
	* @Title: userCancleOrder  
	* @Description: 用户撤销订单 
	* @param request
	* @param orderId
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/userCancleOrder", method = RequestMethod.POST)
	public Object userCancleOrder(HttpServletRequest request, @RequestParam String orderId) {
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, false, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("orderId", orderId);
				hashMap.put("uid", userVO.getUid());
				String json = otcService.userCancleOrder(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 用户撤销订单  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, false, false, false, false);
		}
		
	}
	
	
	
	/**
	 * 
	* @Title: c2cBusOrderHistory  
	* @Description: 查询我的商家接单 
	* @param request
	* @param c2cTransRecordVO
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/busOrderHistory", method = RequestMethod.GET)
	public Object c2cBusOrderHistory(HttpServletRequest request, C2CTransRecordVO c2cTransRecordVO,
									@RequestParam(defaultValue="1") String pageNum,@RequestParam(defaultValue="10") String numPerPage) {
		
		
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, true, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if (null != c2cTransRecordVO.getStartTime() && !StringUtils.isBlank(c2cTransRecordVO.getStartTime())) {
						Long startTime = simple.parse(c2cTransRecordVO.getStartTime()).getTime();
						hashMap.put("startTime", startTime);
					}
					if (null != c2cTransRecordVO.getEndTime() && !StringUtils.isBlank(c2cTransRecordVO.getEndTime())) {
						Long endTime = simple.parse(c2cTransRecordVO.getEndTime()).getTime();
						hashMap.put("endTime", endTime);
					}
				} catch (Exception e) {
					log.error("{} 我的商家接单  时间转换失败");
				}
				
				hashMap.put("symbol", Constants.USDT_Symbol);
				if (null != c2cTransRecordVO.getSymbol()) {
					hashMap.put("symbol", c2cTransRecordVO.getSymbol());
				}
				if (null != c2cTransRecordVO.getType()) {
					hashMap.put("type", c2cTransRecordVO.getType());
				}
				if (null != c2cTransRecordVO.getStatus()) {
					hashMap.put("status", c2cTransRecordVO.getStatus());
				}

				hashMap.put("pageNum", pageNum);
				hashMap.put("numPerPage", numPerPage);
				hashMap.put("uid", userVO.getUid());
				
				String json = otcService.c2cBusOrderHistory(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 查询我的商家接单  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, true, false, false, false);
		}
		
	}
	
	
	
	
	/**
	 * 
	* @Title: userpayFinish  
	* @Description: 用户已付款 
	* @param request
	* @param payPassword
	* @param orderId
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/userPayFinish", method = RequestMethod.POST)
	public Object userPayFinish(HttpServletRequest request, @RequestParam String payPassword,@RequestParam String orderId) {
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, false, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("payPassword", payPassword);
				hashMap.put("orderId", orderId);
				hashMap.put("uid", userVO.getUid());
				String json = otcService.userPayFinish(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 用户已付款  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, false, false, false, false);
		}
		
	}
	
	
	
	
	/**
	 * 
	* @Title: busCheckFinish  
	* @Description: 商家放行 
	* @param request
	* @param payPassword
	* @param orderId
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/busCheckFinish", method = RequestMethod.POST)
	public Object busCheckFinish(HttpServletRequest request, @RequestParam String payPassword,@RequestParam String orderId) {
		
		
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, true, false, false, false) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("payPassword", payPassword);
				hashMap.put("orderId", orderId);
				hashMap.put("uid", userVO.getUid());
				String json = otcService.busCheckFinish(request, hashMap);
				return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 商家放行  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, true, false, false, false);
		}
		
	}
	
	
	
	
	/**
	 * 
	* @Title: userBuySell  
	* @Description: c2c用户下单 
	* @param request
	* @param orderId
	* @param orderNum
	* @param type
	* @param payPassword
	* @param amount
	* @return
	* @return Object
	 */
	@RequestMapping(value = "/userBuySell", method = RequestMethod.POST)
	public Object userBuySell(HttpServletRequest request, @RequestParam String orderId, String orderNum
								,@RequestParam String type, String payPassword, @RequestParam String amount) {
		ResponseResult result = new ResponseResult();
		
		HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true, false, false, false, false) == null ) {
			if (!Toolkits.isBlank(orderNum,payPassword)) {
				try {
					UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
					HashMap<String, Object> hashMap = new HashMap<String, Object>();
					hashMap.put("payPassword", payPassword);
					hashMap.put("orderId", orderId);
					hashMap.put("amount", amount);
					hashMap.put("orderNum", orderNum);
					hashMap.put("type", type);
					hashMap.put("uid", userVO.getUid());
					String json = otcService.userBuySell(request, hashMap);
					return Toolkits.handleResp(json);
				} catch (Exception e) {
					
					result.setCode(ResultCodeMessageUtil.MsgCode100);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
					log.error("{} c2c用户下单  解析后台数据发生异常.", e.toString());
					return result;
				}
			}else {
				result.setCode(ResultCodeMessageUtil.MsgCode102);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode102, request));
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true, false, false, false, false);
		}
		
	}
	

}
