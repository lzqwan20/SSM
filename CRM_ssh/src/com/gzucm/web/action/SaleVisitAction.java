package com.gzucm.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gzucm.domain.SaleVisit;
import com.gzucm.domain.User;
import com.gzucm.service.SaleVisitService;
import com.gzucm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}
	private SaleVisitService saleVisitService;
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}
	
	public String add(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(user);
		saleVisitService.save(saleVisit);
		return "toList";
		
	}

	private Integer currentPage;
	private Integer pageSize;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		//判断并封装参数
		if(saleVisit.getCustomer()!=null &&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id",saleVisit.getCustomer().getCust_id()));
		}
		
		//1 调用Service查询分页数据(PageBean)
		PageBean pb = saleVisitService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	//去往编辑页面回显
		public String toEdit() throws Exception {
				//1 调用Service根据id查询客户拜访对象
				SaleVisit sv = saleVisitService.getById(saleVisit.getVisit_id());
				//2 将对象放入request域
				ActionContext.getContext().put("saleVisit", sv);
				//3 转发到add.jsp
				return "add";
		}

	
}
