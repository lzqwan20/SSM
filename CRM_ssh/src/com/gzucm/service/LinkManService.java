package com.gzucm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gzucm.domain.LinkMan;
import com.gzucm.utils.PageBean;

public interface LinkManService {

	void add(LinkMan linkMan);

	PageBean list(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	LinkMan findLinkManById(DetachedCriteria dc);

}
