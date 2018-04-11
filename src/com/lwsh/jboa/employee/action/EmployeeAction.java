package com.lwsh.jboa.employee.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oracle.net.aso.r;

import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;
import com.lwsh.jboa.base.entity.SYS_RIGHT;
import com.lwsh.jboa.base.entity.SYS_ROLE_RIGHT;
import com.lwsh.jboa.base.entity.TreeNode;
import com.lwsh.jboa.employee.biz.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xerces.internal.dom.ChildNode;

public class EmployeeAction extends ActionSupport {
	
	private EmployeeService employeeService;
	private SYS_EMPLOYEE employee;
	
	/**
	 * ��¼
	 * @return
	 */
	public String login(){
		SYS_EMPLOYEE emp = employeeService.login(employee);
		if (emp!=null) {
			ActionContext.getContext().getSession().put("employee", emp);//����¼�ɹ����û���Ϣ����Session�Ự
			getEmployeeRight(emp);
			return "loginSuccess";
		}else{
			return "loginError";
		}
	}
	
	public void getEmployeeRight(SYS_EMPLOYEE emp){
		//Ȩ�޼���
		List<SYS_RIGHT> rightList = new ArrayList<SYS_RIGHT>();
		Iterator<SYS_ROLE_RIGHT> srr = null;
		try {
			srr = emp.getSysRole().getSysRoleRights().iterator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (srr.hasNext()) {
			SYS_ROLE_RIGHT roleRight = srr.next();
			
			SYS_RIGHT right = new SYS_RIGHT();
			right.setRig_code(roleRight.getSysRight().getRig_code());
			right.setRig_name(roleRight.getSysRight().getRig_name());
			right.setRig_parent_code(roleRight.getSysRight().getRig_parent_code());
			right.setRig_tip(roleRight.getSysRight().getRig_tip());
			right.setRig_type(roleRight.getSysRight().getRig_type());
			right.setRig_url(roleRight.getSysRight().getRig_url());
			rightList.add(right);			
		}
		getRoleTreeList(rightList);
	}
	
	public void getRoleTreeList(List<SYS_RIGHT> rightList){
		//Ȩ��������
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		
		for (SYS_RIGHT parentRight: rightList) {
			if (parentRight.getRig_parent_code().equals("ROOT_MENU")) {
				TreeNode parentNode = new TreeNode();
				parentNode.setId(parentRight.getRig_code());
				parentNode.setText(parentRight.getRig_name());
				parentNode.setUrl(parentRight.getRig_url());
				//�ж��Ӳ˵�
				for (SYS_RIGHT childRight : rightList) {
					if (childRight.getRig_parent_code().equals(parentRight.getRig_code())) {
						TreeNode childNode = new TreeNode();
						childNode.setId(childRight.getRig_code());
						childNode.setText(childRight.getRig_name());
						childNode.setUrl(childRight.getRig_url());
						
						//���Ӳ˵����浽���˵�����ļ�����
						parentNode.getTreeNode().add(childNode);	
					}
								
				}
				//�����˵����浽Ȩ����������
				treeList.add(parentNode);
			}
		
		}
		
		//��Ȩ�������ϱ�����Session��
		ActionContext.getContext().getSession().put("treeList", treeList);
	}
		
		
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public SYS_EMPLOYEE getEmployee() {
		return employee;
	}
	public void setEmployee(SYS_EMPLOYEE employee) {
		this.employee = employee;
	}
	
	
}
