package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 收据单统计表
 * @author 白夜
 *
 */
public class BIZ_CLAIM_VOUCHER_STATISTICS implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;//收据单统计表id
	private Integer total_count;//总消费
	private Integer year;//年份
	private Integer month;//月份
	private Integer department_id;//部门id
	private Date modify_time;//修改时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
}
