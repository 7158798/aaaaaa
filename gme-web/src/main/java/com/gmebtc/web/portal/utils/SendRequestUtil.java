package com.gmebtc.web.portal.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmebtc.web.portal.net.CommonUtil;
import com.gmebtc.web.portal.net.JsonUtil;
import com.gmebtc.web.portal.net.modle.ResultJson;

/*
 * @Author zhou
 * @Date 2018/5/28 14:18
 * @Desc 发送请求到后台
 */
public class SendRequestUtil {

	private static final Logger log = LoggerFactory.getLogger(SendRequestUtil.class);
	
    // 发送带有java pojo参数的post请求
    public static String sendPojoRequest(HttpServletRequest request, Object object, String method) {
        String data = JsonUtil.getJsonStringJavaPOJO(object);
        ResultJson resultJson = null;
        try {
            resultJson = CommonUtil.getResultJson(data, request, method);
        } catch (UnsupportedEncodingException e) {
            log.error("{} 发送请求失败:" + e.toString());
        }
        if (null == resultJson) {
            return null;
        }
        return resultJson.getData().toString();

    }

    // 发送带有map参数的post请求
    public static String sendMapRequest (HttpServletRequest request, HashMap map, String method) throws Exception{
        String data = JsonUtil.hashMapToJson(map);
        ResultJson resultJson = null;
        try {
            resultJson = CommonUtil.getResultJson(data, request, method);
        } catch (UnsupportedEncodingException e) {
            log.error("{} 发送http请求失败:" + e.toString());
            throw new Exception();
        }
        if (null == resultJson) {
            return null;
        }
        return resultJson.getData().toString();
    }


    // 发送没有参数的post请求 直接转发,不做任何处理
    public static String sendRequest(HttpServletRequest request, String method) throws Exception{
        ResultJson resultJson = null;
        try {
            resultJson = CommonUtil.getResultJson(request, method);
        } catch (UnsupportedEncodingException e) {
            log.error("{} 发送请求失败:" + e.toString());
            throw new Exception();
        }
        if (null == resultJson) {
            return null;
        }
        return resultJson.getData().toString();
    }

}
