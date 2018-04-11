package com.lwsh.jboa.claim.dao.impl;

import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER;
import com.lwsh.jboa.base.entity.BIZ_CLAIM_VOUCHER_DETAIL;
import com.lwsh.jboa.base.entity.SYS_EMPLOYEE;
import com.lwsh.jboa.claim.dao.ClaimDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ClaimDaoImpl extends HibernateDaoSupport implements ClaimDao {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public int addClaim(BIZ_CLAIM_VOUCHER claim_voucher) {
        int count = (Integer) this.getHibernateTemplate().save(claim_voucher);
        return count;
    }

    @Override
    public int addClaimDetail(List<BIZ_CLAIM_VOUCHER_DETAIL> detailList) {
        int count = (Integer) this.getHibernateTemplate().save(detailList);
        return count;
    }

    @Override
    public BIZ_CLAIM_VOUCHER getClaimById(Integer id) {
        return (BIZ_CLAIM_VOUCHER) this.getHibernateTemplate().get(BIZ_CLAIM_VOUCHER.class, id);
    }

    @Override
    public void delClaim(BIZ_CLAIM_VOUCHER claim_voucher) {
        this.getHibernateTemplate().delete(claim_voucher);
    }

    @Override
    public void updateClaim(BIZ_CLAIM_VOUCHER claim_voucher) {
        this.getHibernateTemplate().save(claim_voucher);
    }

    @Override
    public void delDetail(final Integer voucherId) {
        this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery query = session.createSQLQuery("DELETE FROM BIZ_CLAIM_VOUCHER_DETAIL WHERE MAIN_ID = :id");
                query.setParameter("id", voucherId);
                query.executeUpdate();
                return null;
            }
        });

    }

    @SuppressWarnings({"null", "unchecked"})
    @Override
    public List<BIZ_CLAIM_VOUCHER> getVoucher(final Map<String, Object> map) {
        return this.getHibernateTemplate().execute(new HibernateCallback<List<BIZ_CLAIM_VOUCHER>>() {

            @Override
            public List<BIZ_CLAIM_VOUCHER> doInHibernate(Session session)
                    throws HibernateException, SQLException {

                Query query = null;
                String hql = "from BIZ_CLAIM_VOUCHER where 1=1";
                if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 1) {//如果查询人是员工
                    hql += " and create.sn = " + ((SYS_EMPLOYEE) map.get("employee")).getSn();//员工编号等于自己的编号?
                    if (map.get("startDate") != null) {//如果开始时间不为空
                        hql += " and create_time>=to_date('" + map.get("startDate")+"','yyyy-MM-dd')";
                    }
                    if ( map.get("endDate") != null) {

                        hql += " and create_time<= to_date('" + map.get("endDate")+"','yyyy-MM-dd')" ;
                    }
                    if (!"0".equals(map.get("status")) && map.get("status") != null) {
                        hql += " and status = '" + (String) map.get("status") + "'";
                    }
                } else if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 2) {

                    hql += " and create.sysDepartment.id= " + ((SYS_EMPLOYEE) map.get("employee")).getSysDepartment().getId() +
                            " and create.sysRole.role_id=1 and status!='新创建'";
                } else if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 3) {

                    hql += " and total_account>=5000 and next_deal.name=" + ((SYS_EMPLOYEE) map.get("employee")).getName();

                } else if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 4) {
                    hql += " and status='已审批'";
                }
                query = session.createQuery(hql);
                query.setFirstResult((Integer) map.get("pageNo"));
                query.setMaxResults((Integer) map.get("pageSize"));
                return query.list();
            }
        });
    }

    @Override
    public Integer getPageCount(final Map<String, Object> map) {

        return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = null;
                String hql = " from BIZ_CLAIM_VOUCHER where 1=1";
                if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 1) {//如果查询人是员工
                    hql += " and create.sn = '" + ((SYS_EMPLOYEE) map.get("employee")).getSn() + "'";//员工编号等于自己的编号?
                    if (map.get("startDate") != null) {//如果开始时间不为空
                        hql += " and create_time>=to_date('" + map.get("startDate")+"','yyyy-MM-dd')";
                    }
                    if ( map.get("endDate")!= null) {

                        hql += " and create_time<=to_date('" + map.get("endDate")+"','yyyy-MM-dd')";
                    }
                    if (!"0".equals(map.get("status")) && (String) map.get("status") != null) {
                        hql += " and status = '" + (String) map.get("status") + "'";
                    }
                } else if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 2) {

                    hql += " and create.sysDepartment.id= " + ((SYS_EMPLOYEE) map.get("employee")).getSysDepartment().getId() +
                            " and create.sysRole.role_id=1 and status!='新创建'";
                } else if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 3) {

                    hql += " and total_account>=5000 and next_deal.name=" + ((SYS_EMPLOYEE) map.get("employee")).getName();

                } else if (((SYS_EMPLOYEE) map.get("employee")).getSysRole().getRole_id() == 4) {
                    hql += " and status='已审批'";
                }

                query = session.createQuery(hql);
                return query.list().size();
            }
        });
    }
}
