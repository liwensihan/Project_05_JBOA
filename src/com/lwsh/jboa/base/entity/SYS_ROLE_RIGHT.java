package com.lwsh.jboa.base.entity;

import java.io.Serializable;
/**
 * ϵͳ��ɫȨ�ޱ�
 * @author ��ҹ
 *
 */
public class SYS_ROLE_RIGHT implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer rf_id;//��ɫȨ��id
	private SYS_RIGHT sysRight;//Ȩ�޶���
	private SYS_ROLE sys_Role;//��ɫ����
	
	
	
	public Integer getRf_id() {
		return rf_id;
	}
	public void setRf_id(Integer rf_id) {
		this.rf_id = rf_id;
	}
	public SYS_RIGHT getSysRight() {
		return sysRight;
	}
	public void setSysRight(SYS_RIGHT sysRight) {
		this.sysRight = sysRight;
	}
	public SYS_ROLE getSys_Role() {
		return sys_Role;
	}
	public void setSys_Role(SYS_ROLE sys_Role) {
		this.sys_Role = sys_Role;
	}
	public SYS_ROLE_RIGHT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SYS_ROLE_RIGHT(Integer rf_id, SYS_RIGHT sysRight, SYS_ROLE sys_Role) {
		super();
		this.rf_id = rf_id;
		this.sysRight = sysRight;
		this.sys_Role = sys_Role;
	}

	
}
