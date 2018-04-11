package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 离职表
 * @author 白夜
 *
 */
public class BIZ_LEAVE implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;//离职表id
	private Integer employee_sn;//员工工号
	private Date starttime;//入岗时间
	private Date endtime;//离岗时间
	private Integer leaveday;//离职日
	private String reason;//离职理由
	private String status;//状态
	private String leavetype;//离职类型
	private Integer next_deal_sn;//下一个处理人工号

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
