package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * <B>ϵͳ���ƣ�</B><BR>
 * <B>ģ�����ƣ�</B><BR>
 * <B>����������Ա���ȼ�ʵ����</B><BR>
 * <B>��Ҫ˵����</B><BR>
 * 
 * @author ��ҹ
 * @since 2018��2��28��
 */
public class SYS_EMPLOYEE implements Serializable {
	/**  */
	private static final long serialVersionUID = 1L;
	private String sn; //Ա������
	private Integer position_id; // ְλ�ȼ�id
	private SYS_DEPARTMENT sysDepartment; // ����id
	private String name; // ����
	private String password; // ����
	private String status; // ״̬
	private SYS_ROLE sysRole;//��ɫ����
	
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
