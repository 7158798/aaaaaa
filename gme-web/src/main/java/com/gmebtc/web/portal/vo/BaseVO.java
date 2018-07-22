package com.gmebtc.web.portal.vo;

import java.io.Serializable;
import java.util.Date;

import com.gmebtc.web.portal.constant.Page;

/**
 * 
 * @Project：gme-web   
 * @Class：BaseVO   
 * @Description 类描述： 分页查询基础vo   
 * @Author：zzh 
 * @Date：2018年7月3日 下午5:17:33   
 * @version v1.0
 */
public class BaseVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * startDate: 开始时间
	 */
	private String startTime;
	
	/**
	 * endDate: 结束时间
	 */
	private String endTime;
	
	
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
}