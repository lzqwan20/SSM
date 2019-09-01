package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.MyCustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

@Service
public class MyCustomerServiceImpl implements MyCustomerService {
	@Autowired
	private MyCustomerDao myCustomerDao;
	// 通过四个条件 查询分页对象
		public Page<Customer> selectPageByQueryVo(QueryVo vo) {
			Page<Customer> page = new Page<Customer>();
			//每页数
			page.setSize(5);
			vo.setSize(5);
			if (null != vo) {
				// 判断当前页
				if (null != vo.getPage()) {
					page.setPage(vo.getPage());
					vo.setStartRow((vo.getPage() -1)*vo.getSize());
				}
				if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
					vo.setCustName(vo.getCustName().trim());
				}
				if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
					vo.setCustSource(vo.getCustSource().trim());
				}
				if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
					vo.setCustIndustry(vo.getCustIndustry().trim());
				}
				if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
					vo.setCustLevel(vo.getCustLevel().trim());
				}
				//总条数
				page.setTotal(myCustomerDao.customerCountByQueryVo(vo));
				page.setRows(myCustomerDao.selectCustomerListByQueryVo(vo));
			}
			return page;

		}
		@Override
		public Customer selectCustomerById(Integer id) {
			
			return myCustomerDao.selectCustomerById(id);
		}
		@Override
		public void updateCustomerById(Customer customer) {
			myCustomerDao.updateCustomerById(customer);
			
		}
		@Override
		public void deleteCustomerById(Integer id) {
			myCustomerDao.deleteCustomerById(id);			
		}

}
