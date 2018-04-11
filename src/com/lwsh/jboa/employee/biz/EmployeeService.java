package com.lwsh.jboa.employee.biz;

import java.util.List;

import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;

public interface EmployeeService {
	
	/**
	 * µÇÂ¼
	 */
	public SYS_EMPLOYEE login(SYS_EMPLOYEE employee);
	
	public List<SYS_EMPLOYEE> getNextDetalByPostionId(Integer postionId);
}
