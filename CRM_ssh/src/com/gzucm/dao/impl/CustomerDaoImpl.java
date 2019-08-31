package com.gzucm.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gzucm.dao.CustomerDao;
import com.gzucm.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public int findTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if(list.size() > 0){
			return list.get(0).intValue();
		}else {
			return 0;
		}
	}

	@Override
	public List<Customer> findListCustomer(DetachedCriteria dc, int start, Integer pageSize) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public void savaCustomer(Customer customer) {
		this.getHibernateTemplate().saveOrUpdate(customer);
		
	}

	@Override
	public Customer getById(DetachedCriteria dc) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size() > 0){
			return list.get(0);
		}else {
			return null;
		}
	}

	


}
