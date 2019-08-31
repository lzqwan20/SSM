package com.gzucm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gzucm.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(DetachedCriteria dc);

}
