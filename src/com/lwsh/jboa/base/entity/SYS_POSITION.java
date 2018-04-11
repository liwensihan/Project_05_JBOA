package com.lwsh.jboa.base.entity;

import java.io.Serializable;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：职位实体类</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 王大帅（Administrator）
 * @since 2018年2月28日
 */
public class SYS_POSITION implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id; // 职位实体类
	private String name_cn; // 职位名称
	private String name_en; // 职位英文名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_cn() {
		return name_cn;
	}

	public void setName_cn(String name_cn) {
		this.name_cn = name_cn;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
}
