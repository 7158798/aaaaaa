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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.gmebtc.web.portal.constant.Constants;
import com.gmebtc.web.portal.constant.ResultCode;
import com.gmebtc.web.portal.constant.SessionAttributes;
import com.gmebtc.web.portal.entity.UserInfo;
import com.gmebtc.web.portal.result.ResponseResult;
import com.gmebtc.web.portal.service.CoinToCoinService;
import com.gmebtc.web.portal.service.SecurityConterService;
import com.gmebtc.web.portal.utils.ResultCodeMessageUtil;
import com.gmebtc.web.portal.utils.Toolkits;
import com.gmebtc.web.portal.vo.UserVO;


/*
 * @Author zhou
 * @Date 2018/5/30 16:58
 * @Desc 币币交易
 */
@RestController
@RequestMapping(value = "${ROOT_PATH}/coin")
public class CoinToCoinController {

	
	private static final Logger log = LoggerFactory.getLogger(CoinToCoinController.class);

    @Resource(name = "coinToCoinService")
    private CoinToCoinService coinToCoinService;
    @Resource(name = "securityConterService")
    private SecurityConterService securityConterService;

    
    
    
    /**
	 * 
	 * @Title: checkUserInfo
	 * @Description:  检查用户信息
	 * @param isCheckLogin 是否检查是否登录
	 * @param isCheckAuth  是否检查是否实名认证
	 * @param isCheckBindPhone 是否检查是否绑定手机
	 * @return  
	 * @return Object
	 */
	public Object checkUserInfo (HttpServletRequest request,boolean isCheckLogin,boolean isCheckAuth,boolean isCheckBindPhone) {
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
    * @Title: cancelBBOrder  
    * @Description: 取消订单 
    * @param request
    * @param orderNum
    * @return
    * @return Object
     */
    @RequestMapping(value = "/cancelCoinOrder", method = RequestMethod.POST)
    public Object cancelCoinOrder(HttpServletRequest request,@RequestParam String orderId) {
    	HttpSession session = request.getSession();
		if (checkUserInfo(request, true, true, true) == null ) {
			try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap.put("orderId", orderId);
				hashMap.put("uid", userVO.getUid());
				String json = coinToCoinService.cancelCoinOrder(request,hashMap);
	            return Toolkits.handleResp(json);
			} catch (Exception e) {
				ResponseResult result = new ResponseResult();
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 取消订单  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true);
		}
    }


    /**
     * 
    * @Title: bbBuySell  
    * @Description: 币币交易 
    * @param request
    * @param pairId 币种交易对编号
    * @param amount 数量
    * @param type 1买 2卖
    * @param price 价格
    * @param tradeAuth 资金密码
    * @return
    * @return Object
     */
    @RequestMapping(value = "/bbBuySell", method = RequestMethod.POST)
    public Object bbBuySell(HttpServletRequest request, @RequestParam String pairId, String amount
            , @RequestParam String type, String price, String tradeAuth) {
    	HttpSession session = request.getSession();
    	ResponseResult result = new ResponseResult();
		if (checkUserInfo(request, true, true, true) == null ) {
			// 验证数据是否完整
		    if (!Toolkits.isBlank(amount,price,tradeAuth)) {
		    	try {
					UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
					HashMap<String, String> hashMap = new HashMap<String, String>();
					hashMap.put("pairId", pairId);
			        hashMap.put("amount", amount);
			        hashMap.put("type", type);
			        hashMap.put("price", price);
			        hashMap.put("payPassword", tradeAuth);
					
		        	String json = coinToCoinService.bbBuySell(request, hashMap);
		            return Toolkits.handleResp(json);
				} catch (Exception e) {
					result.setCode(ResultCodeMessageUtil.MsgCode100);
					result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
					log.error("{} 币币交易  解析后台数据发生异常.", e.toString());
					return result;
				}
		    }else {
		    	result.setCode(ResultCodeMessageUtil.MsgCode102);
		        result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode102, request));
		    	return result;
		    }
		}else {
			return checkUserInfo(request, true, true, true);
		}
        
    }



    /**
     * 
    * @Title: realTimeTradeRecord  
    * @Description: 平台实时交易记录
    * @param request
    * @param pairId
    * @param page
    * @param pageSize
    * @return
    * @return Object
     */
    @RequestMapping(value = "/realTimeTradeRecord", method = RequestMethod.GET)
    public Object realTimeTradeRecord(HttpServletRequest request, @RequestParam String pairId, @RequestParam(defaultValue = "1") String page
            , @RequestParam(defaultValue="40") String pageSize) {
    	
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("pairId", pairId);
        hashMap.put("page", page);
        hashMap.put("pageSize", pageSize);
		try {
			String json = coinToCoinService.realTimeTradeRecord(request, hashMap);
             return Toolkits.handleResp(json);
		} catch (Exception e) {
			ResponseResult result = new ResponseResult();
			result.setCode(ResultCodeMessageUtil.MsgCode100);
			result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
			log.error("{} 平台实时交易记录 发生异常", e.toString());
			return result;
		}
        
        
    }


    /**
     * 
    * @Title: getUserTransactions  
    * @Description:  查询我的交易记录
    * @param request
    * @param pairId
    * @param page
    * @param pageSize
    * @return
    * @return Object
     */
    @RequestMapping(value = "/transRecord", method = {RequestMethod.POST,RequestMethod.GET})
    public Object transRecord(HttpServletRequest request, String pairId,String type
            , @RequestParam(defaultValue = "1") String pageNum,@RequestParam(defaultValue = "10") String numPerPage) {
    	HttpSession session = request.getSession();
    	ResponseResult result = new ResponseResult();
		if (checkUserInfo(request, true, true, true) == null ) {
	    	try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, String> hashMap = new HashMap<String, String>();
				if (null != pairId && !StringUtils.isBlank(pairId)) {
		        	hashMap.put("pairId", pairId);
		        }
		        if (null != type && !StringUtils.isBlank(type)) {
		        	hashMap.put("type", type);
		        }
		        
		        hashMap.put("pageNum", pageNum);
		        hashMap.put("numPerPage",numPerPage);
				hashMap.put("uid", userVO.getUid());
				
		        String json = coinToCoinService.transRecord(request, hashMap);
	            return Toolkits.handleResp(json);
			} catch (Exception e) {
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 查询我的交易记录  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true);
		}
    } 


    /**
     * 
    * @Title: entrustRecord  
    * @Description: 查询我的委托记录 
    * @param request
    * @param pairId
    * @param type 	1买，2卖，3全部
    * @param page
    * @param pageSize
    * @return
    * @return Object
     */
    @RequestMapping(value = "/entrustRecord", method =  {RequestMethod.POST,RequestMethod.GET})
    public Object entrustRecord (HttpServletRequest request,String pairId, String type
                                ,@RequestParam(defaultValue = "1") String pageNum,@RequestParam(defaultValue = "10") String numPerPage){
    	HttpSession session = request.getSession();
    	ResponseResult result = new ResponseResult();
		if (checkUserInfo(request, true, true, true) == null ) {
	    	try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, String> hashMap = new HashMap<String, String>();
				if (null != type && !StringUtils.isBlank(type)) {
		        	hashMap.put("type", type);
		        }
		        if (null != pairId && !StringUtils.isBlank(pairId)) {
		        	hashMap.put("pairId", pairId);
		        }
		        
		        hashMap.put("pageNum", pageNum);
		        hashMap.put("numPerPage", numPerPage);
				hashMap.put("uid", userVO.getUid());
				
				String json = coinToCoinService.entrustRecord(request, hashMap);
	            return Toolkits.handleResp(json);
			} catch (Exception e) {
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 查询我的委托记录  解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true);
		}
        
    }


    
    /**
     * 
    * @Title: getBuySellOrders  
    * @Description: 查询买卖委托单 
    * @param request
    * @param coinTradeId
    * @param type
    * @param pageSize
    * @return
    * @return Object
     */
    @RequestMapping(value = "/buySellOrders",method = RequestMethod.GET)
    public Object getBuySellOrders (HttpServletRequest request,@RequestParam String pairId,@RequestParam(defaultValue="20") String pageSize){
        ResponseResult result = new ResponseResult();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("pairId", pairId);
        hashMap.put("pageSize", pageSize);
		try {
        	 String json = coinToCoinService.getBuySellOrders(request,hashMap);
             return Toolkits.handleResp(json);
		} catch (Exception e) {
			result.setCode(ResultCodeMessageUtil.MsgCode100);
			result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
			log.error("{} 查询买卖委托单  解析后台数据发生异常.", e.toString());
			return result;
		}
        
    }
    
    
    
    
    /**
     * 
    * @Title: queryDetial  
    * @Description: 查询详情 
    * @param request
    * @param orderId
    * @return
    * @return Object
     */
    @RequestMapping(value = "/queryDetial",method = RequestMethod.POST)
    public Object queryDetial (HttpServletRequest request,@RequestParam String orderId){
    	HttpSession session = request.getSession();
    	ResponseResult result = new ResponseResult();
		if (checkUserInfo(request, true, true, true) == null ) {
	    	try {
				UserVO userVO = (UserVO) session.getAttribute(SessionAttributes.LOGIN_SECONDLOGIN);
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap.put("orderId", orderId);
				
				String json = coinToCoinService.queryDetial(request,hashMap);
	             return Toolkits.handleResp(json);
			} catch (Exception e) {
				result.setCode(ResultCodeMessageUtil.MsgCode100);
				result.setMessage(ResultCodeMessageUtil.getCodeMessage(ResultCodeMessageUtil.MsgCode100, request));
				log.error("{} 查询详情   解析后台数据发生异常.", e.toString());
				return result;
			}
		}else {
			return checkUserInfo(request, true, true, true);
		}
    	
    }
    
    
}
