package com.gzucm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gzucm.domain.SaleVisit;

public interface SaleVisitDao {

	void save(SaleVisit saleVisit);

	Integer getTotalCount(DetachedCriteria dc);

	List<SaleVisit> getPageList(DetachedCriteria dc, int start, Integer pageSize);

	SaleVisit getById(String visit_id);

}
