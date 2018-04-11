package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：员工等级实体类</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 白夜
 * @since 2018年2月28日
 */
public class SYS_EMPLOYEE implements Serializable {
	/**  */
	private static final long serialVersionUID = 1L;
	private String sn; //员工工号
	private Integer position_id; // 职位等级id
	private SYS_DEPARTMENT sysDepartment; // 部门id
	private String name; // 姓名
	private String password; // 密码
	private String status; // 状态
	private SYS_ROLE sysRole;//角色对象
	
	public SYS_EMPLOYEE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SYS_ROLE getSysRole() {
		return sysRole;
	}

	public void setSysRole(SYS_ROLE sysRole) {
		this.sysRole = sysRole;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SYS_DEPARTMENT getSysDepartment() {
		return sysDepartment;
	}

	public void setSysDepartment(SYS_DEPARTMENT sysDepartment) {
		this.sysDepartment = sysDepartment;
	}

}
