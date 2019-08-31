package com.gzucm.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gzucm.domain.Customer;
import com.gzucm.domain.LinkMan;
import com.gzucm.service.LinkManService;
import com.gzucm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	
	private Integer currentPage;
	private Integer pageSize;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public String add(){
		linkManService.add(linkMan);
		return "toList";
		
	}
	
	public String list() throws IOException{
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("cust_name", "%"+linkMan.getLkm_name()+"%"));
		}
		PageBean pageBean = linkManService.list(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		System.out.println(pageBean.getList().toString());
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write("json");
		return "list";
	}
	
	public String toEdit(){
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		dc.add(Restrictions.eq("lkm_id",linkMan.getLkm_id()));
		LinkMan linkMan = linkManService.findLinkManById(dc);
		ActionContext.getContext().put("linkMan", linkMan);
		System.out.println(linkMan.getLkm_name());
		return "add";
		
	}
	
	
}
