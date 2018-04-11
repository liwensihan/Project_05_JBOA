package com.lwsh.jboa.employee.biz.impl;

import java.util.List;

import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;
import com.lwsh.jboa.employee.biz.EmployeeService;
import com.lwsh.jboa.employee.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}


	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}


	@Override
	public SYS_EMPLOYEE login(SYS_EMPLOYEE employee) {
		return employeeDao.login(employee);
	}


	@Override
	public List<SYS_EMPLOYEE> getNextDetalByPostionId(Integer postionId) {
		
		return employeeDao.getNextDetalByPostionId(postionId);
	}

}
