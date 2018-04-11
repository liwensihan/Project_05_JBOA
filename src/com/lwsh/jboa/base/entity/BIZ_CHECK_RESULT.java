package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：审核结果实体类</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 李文思汗（Administrator）
 * @since 2018年2月28日
 */
public class BIZ_CHECK_RESULT implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id; // 审核结果id
	private BIZ_CLAIM_VOUCHER bizclaimvoucher; // 报销单
	private Date check_time; // 审核结果时间
	private SYS_EMPLOYEE checkEmployee; //审查人对象	
	private String result; // 结果
	private String comm; // 批注
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public BIZ_CLAIM_VOUCHER getBizclaimvoucher() {
		return bizclaimvoucher;
	}

	public void setBizclaimvoucher(BIZ_CLAIM_VOUCHER bizclaimvoucher) {
		this.bizclaimvoucher = bizclaimvoucher;
	}

	public Date getCheck_time() {
		return check_time;
	}

	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}


	public SYS_EMPLOYEE getCheckEmployee() {
		return checkEmployee;
	}

	public void setCheckEmployee(SYS_EMPLOYEE checkEmployee) {
		this.checkEmployee = checkEmployee;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}


}
