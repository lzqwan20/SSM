package com.gzucm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gzucm.dao.BaseDictDao;
import com.gzucm.domain.BaseDict;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	@Override
	public List<BaseDict> getListByTypeCode(DetachedCriteria dc) {
		List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
