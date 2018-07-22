package com.gmebtc.web.portal.vo;

import java.io.Serializable;


/**
 * 
 * @Project：gme-web   
 * @Class：PageVO   
 * @Description 类描述： 后台返回的存储分页的对象
 * @Author：zzh 
 * @Date：2018年6月30日 下午6:19:13   
 * @version v1.0
 * @param <T>
 */
public class PageVO<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * code: 状态
	 */
	private String code;
	/**
	 * message: 消息
	 */
	private String message;
	/**
	 * data:分页的对象
	 */
	private T data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}

