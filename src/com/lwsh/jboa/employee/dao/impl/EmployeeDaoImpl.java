package com.lwsh.jboa.employee.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;
import com.lwsh.jboa.employee.dao.EmployeeDao;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	public SYS_EMPLOYEE login(final SYS_EMPLOYEE employee) {
	
		return this.getHibernateTemplate().execute(new HibernateCallback<SYS_EMPLOYEE>() {

			@Override
			public SYS_EMPLOYEE doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from SYS_EMPLOYEE where sn= :sn and password= :password");
				query.setParameter("sn", employee.getSn());
				query.setParameter("password", employee.getPassword());
				return (SYS_EMPLOYEE)query.uniqueResult();
			}			
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SYS_EMPLOYEE> getNextDetalByPostionId(Integer postionId) {
		
		return this.getHibernateTemplate().find("from SYS_EMPLOYEE where position_id = ?",postionId);
	}

}
