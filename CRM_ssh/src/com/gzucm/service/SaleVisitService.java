package com.gzucm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gzucm.domain.SaleVisit;
import com.gzucm.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	SaleVisit getById(String visit_id);

}
