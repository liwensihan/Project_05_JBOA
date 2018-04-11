package com.lwsh.jboa.base.entity;

import java.io.Serializable;
/**
 * 报销单明细表
 * @author 白夜
 *
 */
public class BIZ_CLAIM_VOUCHER_DETAIL implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;//报销单明细表id
	private BIZ_CLAIM_VOUCHER bizClaimVoucher;//报销总表对象
	private String item;//项目
	private Integer account;//消费金额
	private String des;//项目描述
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public BIZ_CLAIM_VOUCHER getBizClaimVoucher() {
		return bizClaimVoucher;
	}

	public void setBizClaimVoucher(BIZ_CLAIM_VOUCHER bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public String getdes() {
		return des;
	}

	public void setdes(String des) {
		this.des = des;
	}
}
