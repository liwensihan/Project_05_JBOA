package com.lwsh.jboa.base.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <B>ϵͳ���ƣ�</B><BR>
 * <B>ģ�����ƣ�</B><BR>
 * <B>������������˽��ʵ����</B><BR>
 * <B>��Ҫ˵����</B><BR>
 * 
 * @author ����˼����Administrator��
 * @since 2018��2��28��
 */
public class BIZ_CHECK_RESULT implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer id; // ��˽��id
	private BIZ_CLAIM_VOUCHER bizclaimvoucher; // ������
	private Date check_time; // ��˽��ʱ��
	private SYS_EMPLOYEE checkEmployee; //����˶���	
	private String result; // ���
	private String comm; // ��ע
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public BIZ_CLAIM_VOUCHER getBizclaimvoucher() {
		return bizclaimvoucher;
	}

	public void setBizclaimvoucher(BIZ_CLAIM_VOUCHER bizclaimvoucher) {
		this.bizclaimvoucher = bizclaimvoucher;
	}

	public Date getCheck_time() {
		return check_time;
	}

	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}


	public SYS_EMPLOYEE getCheckEmployee() {
		return checkEmployee;
	}

	public void setCheckEmployee(SYS_EMPLOYEE checkEmployee) {
		this.checkEmployee = checkEmployee;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}


}
