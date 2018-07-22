package com.gmebtc.web.portal.entity;

import java.io.Serializable;

public class BindAliPayWeChat implements Serializable{
	private static final long serialVersionUID = 1L;
	/* 收款码图片*/
    private String qrImgId;
    /* 1，支付宝，2，微信*/
    private String type;
    /* 账号*/
    private String account;
    /* 备注*/
    private String remark;
    /* 资金密码*/
    private String tradeAuth;


	public String getQrImgId() {
		return qrImgId;
	}

	public void setQrImgId(String qrImgId) {
		this.qrImgId = qrImgId;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getTradeAuth() {
		return tradeAuth;
	}

	public void setTradeAuth(String tradeAuth) {
		this.tradeAuth = tradeAuth;
	}

}
