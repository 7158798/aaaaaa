package com.gmebtc.web.portal.entity;

import java.io.Serializable;

public class WorkList implements Serializable{
	private static final long serialVersionUID = 1L;
	/* 工单的币种*/
    private String currencyId;
    /* 工单类型（1充值，2提现，3申诉，4，仲裁，5其他）*/
    private String workType;
    /* 业务编号*/
    private String bizId;
    /* 	工单内容*/
    private String workContent;
    /* 图片1*/
    private String imgOne;
    /* 图片2*/
    private String imgTwo;
    /* 图片3*/
    private String imgThree;
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public String getImgOne() {
		return imgOne;
	}
	public void setImgOne(String imgOne) {
		this.imgOne = imgOne;
	}
	public String getImgTwo() {
		return imgTwo;
	}
	public void setImgTwo(String imgTwo) {
		this.imgTwo = imgTwo;
	}
	public String getImgThree() {
		return imgThree;
	}
	public void setImgThree(String imgThree) {
		this.imgThree = imgThree;
	}
}
