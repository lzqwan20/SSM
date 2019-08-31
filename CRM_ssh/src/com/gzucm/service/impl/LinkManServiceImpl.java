package com.gzucm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.dao.LinkManDao;
import com.gzucm.domain.Customer;
import com.gzucm.domain.LinkMan;
import com.gzucm.service.LinkManService;
import com.gzucm.utils.PageBean;
@Transactional
public class LinkManServiceImpl implements LinkManService {
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}



	@Override
	public void add(LinkMan linkMan) {
		linkManDao.add(linkMan);

	}



	@Override
	public PageBean list(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		//通过customer_name来查询有多少条记录
		int totalCount = linkManDao.findTotalCount(dc);
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//通过pageSize和currentPage和customer_name来查询list对象
		List<LinkMan> list = linkManDao.findListLinkMan(dc,pageBean.getStart(),pageBean.getPageSize());
		//将所有的东西封装到pageBean
		pageBean.setList(list);
		return pageBean;
	}



	@Override
	public LinkMan findLinkManById(DetachedCriteria dc) {
		return linkManDao.findLinkManById(dc);
	}


}
