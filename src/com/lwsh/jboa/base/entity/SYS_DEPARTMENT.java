package com.lwsh.jboa.base.entity;

import java.io.Serializable;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：部门实体类</B><BR>
 * <B>概要说明：</B><BR>
 * 
 *
 */
public class SYS_DEPARTMENT implements Serializable {
	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id; // 部门编号
	private String name; // 部门名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
