package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BIZ_CLAIM_VOUCHER implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;	//��ȱ���ͳ��
	private SYS_EMPLOYEE next_deal;//��һ�������˶���
	private SYS_EMPLOYEE create;//�����˶���
	private Date create_time;//����ʱ��
	private String event;//������
	private Integer total_account;//�����ܽ��
	private String status;//������״̬
	private Date modify_time;//�޸�ʱ��
	private Set<BIZ_CHECK_RESULT> bizCheckResults = new HashSet<BIZ_CHECK_RESULT>();//һ�Զ�
	private Set<BIZ_CLAIM_VOUCHER_DETAIL> bizClaimVoucherDetails = new HashSet<BIZ_CLAIM_VOUCHER_DETAIL>();//һ�Զ�	
	public Set<BIZ_CHECK_RESULT> getBizCheckResults() {
		return bizCheckResults;
	}

	public void setBizCheckResults(Set<BIZ_CHECK_RESULT> bizCheckResults) {
		this.bizCheckResults = bizCheckResults;
	}

	public Set<BIZ_CLAIM_VOUCHER_DETAIL> getBizClaimVoucherDetails() {
		return bizClaimVoucherDetails;
	}

	public void setBizClaimVoucherDetails(
			Set<BIZ_CLAIM_VOUCHER_DETAIL> bizClaimVoucherDetails) {
		this.bizClaimVoucherDetails = bizClaimVoucherDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public SYS_EMPLOYEE getNext_deal() {
		return next_deal;
	}

	public void setNext_deal(SYS_EMPLOYEE next_deal) {
		this.next_deal = next_deal;
	}

	public SYS_EMPLOYEE getCreate() {
		return create;
	}

	public void setCreate(SYS_EMPLOYEE create) {
		this.create = create;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Integer getTotal_account() {
		return total_account;
	}

	public void setTotal_account(Integer total_account) {
		this.total_account = total_account;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
}
