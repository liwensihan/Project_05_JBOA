package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;

public class BIZ_CLAIM_VOUYEAR__STATISTICS implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;//年度报销统计
	private String total_count;//报销总金费
	private String year;//年份
	private Date modify_time;//修改时间
	private String depatrment_id;//部门编号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTotal_count() {
		return total_count;
	}

	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public String getDepatrment_id() {
		return depatrment_id;
	}

	public void setDepatrment_id(String depatrment_id) {
		this.depatrment_id = depatrment_id;
	}
}
