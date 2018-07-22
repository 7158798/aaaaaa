package com.gmebtc.web.portal.net;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmebtc.web.portal.net.modle.ResultJson;
import com.gmebtc.web.portal.utils.ConfigUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

/**
 * @param
 * @Description: 封装API消息头 和 连接后台服务
 * @Author : Jinny.Ding
 * @Date: 2016年10月1日 下午3:50:25
 * @Version: 1.0 .
 */
public class CommonUtil {

	private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);
	


    public static final String ROLE_ID = "roleId";

    public static final String USER_ID = "userId";
    public static final String PWD = "pwd";
    public static final String USER_TYPE = "userType";
    public static final String TOKEN = "token";
    public static final String GME = "gme";
    public static final String ACCOUNT = "account";

    /**
     * @param
     * @return
     * @throws UnsupportedEncodingException
     * @description 连接后台服务
     * @date 2015-10-17下午3:54:15
     */
    public static ResultJson getResultJson(String data, HttpServletRequest request, String method) throws UnsupportedEncodingException {
    	ResultJson resultJson = new ResultJson(true);
        Object json = new JSONTokener(data).nextValue();
//        Map<String, String> param = getCommonHead(request, method);
        Map<String,String> param = new HashMap<String,String>();
        String postUrl = "";
        if (!"".equals(method)) {
            postUrl = method;
        } else {
            postUrl = null;
        }
        if (json instanceof JSONObject) {
            JSONObject dataParam = JSONObject.fromObject(data);
            for (Object keyObject : dataParam.keySet()) {
                String key = keyObject.toString();
                String value = dataParam.getString(key);
                param.put(key, value);
            }
        } else if (json instanceof JSONArray) {
            param.put("json_array", data);
        }

        String paramStr = param.toString();
        log.info("请求地址：" + postUrl);
        log.info("请求参数：" + paramStr);


        doPost(resultJson, param, postUrl);
        return resultJson;
    }

    /**
     * 
     * @Title: getResultJson
     * @Description: TODO  没有参数传递的http post请求
     * @param @param request
     * @param @param method
     * @param @return
     * @param @throws UnsupportedEncodingException
     * @return ResultJson
     * @throws
     */
    public static ResultJson getResultJson(HttpServletRequest request, String method) throws UnsupportedEncodingException {
    	ResultJson resultJson = new ResultJson(true);
        //HttpSession session = request.getSession();
//        Map<String, String> param = getCommonHead(request, method);
        Map<String,String> param = new HashMap<String,String>();
//        param.putAll(getParameterMap(request));
        String postUrl = "";
        if (!"".equals(method)) {
            postUrl = method;
        } else {
            postUrl = null;
        }

        String paramStr = param.toString();
        log.info("请求地址：" + postUrl);
        log.info("请求参数：" + paramStr);


        doPost(resultJson, param, postUrl);
        return resultJson;
    }
    

    private static void doPost(ResultJson resultJson, Map<String, String> param, String postUrl) {
        try {
            HttpData httpData = HttpTookit.doPost(postUrl, param, "utf-8", true);
            Integer statusCode = httpData.getStatusCode();
            String statusText = httpData.getStatusText();
            String response = httpData.getResponse();
            log.info("http======>statusCode:" + statusCode + "  statusText:" + statusText);
            String msgInfo = postUrl.substring(postUrl.lastIndexOf('/')+1, postUrl.lastIndexOf('.'));
            log.info("服务器响应内容："  + msgInfo + "=" + response);
            if (statusCode == HttpStatus.SC_OK) {
            	JSONObject resultObject = JSONObject.fromObject(response);
                String msg = resultObject.getString("message");
                resultJson.setMessage(msg);
                resultJson.setCode(resultObject.getString("code"));
                resultJson.setData(resultObject);
            }
        } catch (Exception e) {
            JSONObject resultObject = new JSONObject();
            resultObject.put("code", "500");
            resultObject.put("message", "系统繁忙，请稍后再试");
            resultObject.put("data", "");
            resultJson.setMessage("系统繁忙，请稍后再试");
            resultJson.setSuccess(false);
            resultJson.setData(resultObject);
        }
    }


    /**
     * @Author zhou
     * @Date 2018/5/30 14:20
     * @Param [request]
     * @Desc 从request中获得参数map,并返回可读的map
     */
    private static Map getParameterMap (HttpServletRequest request){
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }


    /**
     * 封装API消息头
     *
     * @param request
     * @param method
     * @return
     */
    public static Map<String, String> getCommonHead(HttpServletRequest request, String method) {

        HashMap<String, String> head = new HashMap<String, String>();
        HttpSession session = request.getSession();
        String format = ConfigUtil.get("format");
        String appType = ConfigUtil.get("appType");
        String appVersion = ConfigUtil.get("appVersion");
        String timestamp = System.currentTimeMillis() + "";
        //session.setAttribute(USER_ID, "21322");
        Object uid = (session.getAttribute(CommonUtil.USER_ID) == null ? "" : session.getAttribute(CommonUtil.USER_ID));
        Object utype = (session.getAttribute(USER_TYPE) == null ? "" : session.getAttribute(USER_TYPE));
        Object token = (session.getAttribute(TOKEN) == null ? "" : session.getAttribute(TOKEN));

        StringBuffer sb = new StringBuffer(GME);
        sb.append("appKey").append("");
        sb.append("appType").append(appType);
        sb.append("appVersion").append(appVersion);
        sb.append("channelId").append("");
        sb.append("format").append(format);
        sb.append("timestamp").append(timestamp);
        sb.append("token").append(token);
        sb.append("uid").append(uid);
        sb.append("utype").append(utype);
        sb.append(GME);

        String sign = CryptoUtil.md5Encode(sb.toString()).toUpperCase();

        head.put("appKey", "");
        head.put("appType", appType);
        head.put("appVersion", appVersion);
        head.put("channelId", "");
        head.put("format", format);
        head.put("timestamp", timestamp);
        head.put("token", token.toString());
        head.put("uid", uid.toString());
        head.put("utype", utype.toString());
        head.put("sign", sign);


        Map<String, String> requestBody = new HashMap<String, String>();
        requestBody.put("sysParams", JSONObject.fromObject(head).toString());

        return requestBody;
    }
}
