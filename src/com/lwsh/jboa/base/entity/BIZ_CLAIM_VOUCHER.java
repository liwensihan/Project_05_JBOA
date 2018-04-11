package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BIZ_CLAIM_VOUCHER implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;	//年度报销统计
	private SYS_EMPLOYEE next_deal;//下一个审批人对象
	private SYS_EMPLOYEE create;//创建人对象
	private Date create_time;//创建时间
	private String event;//消费项
	private Integer total_account;//报销总金费
	private String status;//报销单状态
	private Date modify_time;//修改时间
	private Set<BIZ_CHECK_RESULT> bizCheckResults = new HashSet<BIZ_CHECK_RESULT>();//一对多
	private Set<BIZ_CLAIM_VOUCHER_DETAIL> bizClaimVoucherDetails = new HashSet<BIZ_CLAIM_VOUCHER_DETAIL>();//一对多	
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
