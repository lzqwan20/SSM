package com.gzucm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gzucm.dao.LinkManDao;
import com.gzucm.domain.Customer;
import com.gzucm.domain.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@Override
	public void add(LinkMan linkMan) {
		this.getHibernateTemplate().saveOrUpdate(linkMan);
	}

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
	public List<LinkMan> findListLinkMan(DetachedCriteria dc, int start, Integer pageSize) {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public LinkMan findLinkManById(DetachedCriteria dc) {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(dc);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}


}
