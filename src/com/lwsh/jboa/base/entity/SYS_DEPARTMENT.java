package com.lwsh.jboa.base.entity;

import java.io.Serializable;

/**
 * 
 * <B>ϵͳ���ƣ�</B><BR>
 * <B>ģ�����ƣ�</B><BR>
 * <B>��������������ʵ����</B><BR>
 * <B>��Ҫ˵����</B><BR>
 * 
 *
 */
public class SYS_DEPARTMENT implements Serializable {
	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id; // ���ű��
	private String name; // ��������

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
