package com.gzucm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.gzucm.dao.SaleVisitDao;
import com.gzucm.domain.SaleVisit;
import com.gzucm.service.SaleVisitService;
import com.gzucm.utils.PageBean;
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao saleVisitDao;
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
		
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<SaleVisit> list = saleVisitDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	@Override
	public SaleVisit getById(String visit_id) {
		
		return saleVisitDao.getById(visit_id);
	}

	
}
