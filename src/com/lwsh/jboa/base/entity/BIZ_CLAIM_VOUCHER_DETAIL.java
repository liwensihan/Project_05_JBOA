package com.lwsh.jboa.base.entity;

import java.io.Serializable;
/**
 * ��������ϸ��
 * @author ��ҹ
 *
 */
public class BIZ_CLAIM_VOUCHER_DETAIL implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id;//��������ϸ��id
	private BIZ_CLAIM_VOUCHER bizClaimVoucher;//�����ܱ����
	private String item;//��Ŀ
	private Integer account;//���ѽ��
	private String des;//��Ŀ����
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
