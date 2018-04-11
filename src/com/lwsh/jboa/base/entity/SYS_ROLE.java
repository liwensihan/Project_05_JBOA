package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SYS_ROLE implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	
	private Integer role_id;//角色id;
	private String 	role_name;//角色名
	private String 	role_desc;//角色描述
	private Integer role_flag;//
	/**
	 * 员工集合
	 */
	private Set<SYS_EMPLOYEE> sysEmps = new HashSet<SYS_EMPLOYEE>(); 
	/**
	 * 角色权限集合
	 */
	private Set<SYS_ROLE_RIGHT> sysRoleRights = new HashSet<SYS_ROLE_RIGHT>();
	public SYS_ROLE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SYS_ROLE(Integer role_id, String role_name, String role_desc,
			Integer role_flag, Set<SYS_EMPLOYEE> sysEmps,
			Set<SYS_ROLE_RIGHT> sysRoleRights) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_desc = role_desc;
		this.role_flag = role_flag;
		this.sysEmps = sysEmps;
		this.sysRoleRights = sysRoleRights;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public Integer getRole_flag() {
		return role_flag;
	}
	public void setRole_flag(Integer role_flag) {
		this.role_flag = role_flag;
	}
	public Set<SYS_EMPLOYEE> getSysEmps() {
		return sysEmps;
	}
	public void setSysEmps(Set<SYS_EMPLOYEE> sysEmps) {
		this.sysEmps = sysEmps;
	}
	public Set<SYS_ROLE_RIGHT> getSysRoleRights() {
		return sysRoleRights;
	}
	public void setSysRoleRights(Set<SYS_ROLE_RIGHT> sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}
	
	
}
