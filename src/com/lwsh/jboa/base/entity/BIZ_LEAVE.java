package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * ��ְ��
 * @author ��ҹ
 *
 */
public class BIZ_LEAVE implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;//��ְ��id
	private Integer employee_sn;//Ա������
	private Date starttime;//���ʱ��
	private Date endtime;//���ʱ��
	private Integer leaveday;//��ְ��
	private String reason;//��ְ����
	private String status;//״̬
	private String leavetype;//��ְ����
	private Integer next_deal_sn;//��һ�������˹���

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployee_sn() {
		return employee_sn;
	}

	public void setEmployee_sn(Integer employee_sn) {
		this.employee_sn = employee_sn;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getLeaveday() {
		return leaveday;
	}

	public void setLeaveday(Integer leaveday) {
		this.leaveday = leaveday;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public Integer getNext_deal_sn() {
		return next_deal_sn;
	}

	public void setNext_deal_sn(Integer next_deal_sn) {
		this.next_deal_sn = next_deal_sn;
	}

	public String getApprove_opinion() {
		return approve_opinion;
	}

	public void setApprove_opinion(String approve_opinion) {
		this.approve_opinion = approve_opinion;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	private String approve_opinion;
	private Date createtime;
	private Date modifytime;
}
