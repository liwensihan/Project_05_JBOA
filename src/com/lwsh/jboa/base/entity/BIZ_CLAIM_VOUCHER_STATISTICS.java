package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * �վݵ�ͳ�Ʊ�
 * @author ��ҹ
 *
 */
public class BIZ_CLAIM_VOUCHER_STATISTICS implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id;//�վݵ�ͳ�Ʊ�id
	private Integer total_count;//������
	private Integer year;//���
	private Integer month;//�·�
	private Integer department_id;//����id
	private Date modify_time;//�޸�ʱ��

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
