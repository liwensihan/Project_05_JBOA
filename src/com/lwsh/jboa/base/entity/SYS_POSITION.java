package com.lwsh.jboa.base.entity;

import java.io.Serializable;

/**
 * 
 * <B>ϵͳ���ƣ�</B><BR>
 * <B>ģ�����ƣ�</B><BR>
 * <B>����������ְλʵ����</B><BR>
 * <B>��Ҫ˵����</B><BR>
 * 
 * @author ����˧��Administrator��
 * @since 2018��2��28��
 */
public class SYS_POSITION implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;
	private Integer id; // ְλʵ����
	private String name_cn; // ְλ����
	private String name_en; // ְλӢ������

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
