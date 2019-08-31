package com.gzucm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.dao.BaseDictDao;
import com.gzucm.domain.BaseDict;
import com.gzucm.service.BaseDictService;
@Transactional
public class BaseDictServiceImpl implements BaseDictService{
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> getListByTypeCode(DetachedCriteria dc) {
		return baseDictDao.getListByTypeCode(dc);
	}

}
