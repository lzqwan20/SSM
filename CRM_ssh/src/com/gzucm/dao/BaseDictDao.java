package com.gzucm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gzucm.domain.BaseDict;

public interface BaseDictDao {

	List<BaseDict> getListByTypeCode(DetachedCriteria dc);

}
