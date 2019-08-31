package com.gzucm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gzucm.dao.SaleVisitDao;
import com.gzucm.domain.Customer;
import com.gzucm.domain.SaleVisit;

public class SaleVisitDaoImpl extends HibernateDaoSupport implements SaleVisitDao {

	@Override
	public void save(SaleVisit saleVisit) {
		this.getHibernateTemplate().save(saleVisit);
		
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
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
	public List<SaleVisit> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		List<SaleVisit> list = (List<SaleVisit>) this.getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public SaleVisit getById(String visit_id) {
		
		return this.getHibernateTemplate().get(SaleVisit.class, visit_id);
	}
		
}
