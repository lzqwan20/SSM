package com.gzucm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gzucm.domain.Customer;
import com.gzucm.domain.LinkMan;

public interface LinkManDao {

	void add(LinkMan linkMan);

	int findTotalCount(DetachedCriteria dc);

	List<LinkMan> findListLinkMan(DetachedCriteria dc, int start, Integer pageSize);

	LinkMan findLinkManById(DetachedCriteria dc);

	

}
