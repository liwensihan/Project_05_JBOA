package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SYS_RIGHT  implements Serializable{

	/**  */
	private static final long serialVersionUID = 1L;
	
	private String	rig_code;//权限编号
	private String 	rig_parent_code;//父权限编号
	private String 	rig_name;//权限名
	private String 	rig_url;//权限地址
	private String 	rig_tip;//权限标签
	private String 	rig_type;//权限类型
	private Set<SYS_ROLE_RIGHT> sysRoleRights = new HashSet<SYS_ROLE_RIGHT>();
	
	
	public SYS_RIGHT(String rig_code, String rig_parent_code, String rig_name,
			String rig_url, String rig_tip, String rig_type,
			Set<SYS_ROLE_RIGHT> sysRoleRights) {
		super();
		this.rig_code = rig_code;
		this.rig_parent_code = rig_parent_code;
		this.rig_name = rig_name;
		this.rig_url = rig_url;
		this.rig_tip = rig_tip;
		this.rig_type = rig_type;
		this.sysRoleRights = sysRoleRights;
	}
	
	public SYS_RIGHT() {
		super();
	}

	/**
	 * 系统角色权限集合
	 */
	
	public String getRig_code() {
		return rig_code;
	}
	public void setRig_code(String rig_code) {
		this.rig_code = rig_code;
	}
	public String getRig_parent_code() {
		return rig_parent_code;
	}
	public void setRig_parent_code(String rig_parent_code) {
		this.rig_parent_code = rig_parent_code;
	}
	public String getRig_name() {
		return rig_name;
	}
	public void setRig_name(String rig_name) {
		this.rig_name = rig_name;
	}
	public String getRig_url() {
		return rig_url;
	}
	public void setRig_url(String rig_url) {
		this.rig_url = rig_url;
	}
	public String getRig_tip() {
		return rig_tip;
	}
	public void setRig_tip(String rig_tip) {
		this.rig_tip = rig_tip;
	}
	public String getRig_type() {
		return rig_type;
	}
	public void setRig_type(String rig_type) {
		this.rig_type = rig_type;
	}

}
