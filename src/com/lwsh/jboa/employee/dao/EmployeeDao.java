package com.lwsh.jboa.employee.dao;

import java.util.List;

import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;




public interface EmployeeDao {
	/**
	 * µÇÂ¼
	 * @param employee
	 * @return
	 */
	public SYS_EMPLOYEE login(SYS_EMPLOYEE employee);
	
	public List<SYS_EMPLOYEE> getNextDetalByPostionId(Integer postionId);
}
