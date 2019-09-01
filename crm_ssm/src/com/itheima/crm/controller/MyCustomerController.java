package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.MyBaseDictService;
import com.itheima.crm.service.MyCustomerService;
@Controller
public class MyCustomerController {
	@Autowired
	private MyBaseDictService mybaseDictService;
	@Autowired
	private MyCustomerService myCustomerService;
	@RequestMapping(value = "/mycustomer/list")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = mybaseDictService.selectBaseListByCode("002");
		List<BaseDict> industryType = mybaseDictService.selectBaseListByCode("001");
		List<BaseDict> levelType = mybaseDictService.selectBaseListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		
		
		//通过四个条件  查询分页对象
				Page<Customer> page = myCustomerService.selectPageByQueryVo(vo);
				model.addAttribute("page", page);
				model.addAttribute("custName", vo.getCustName());
				model.addAttribute("custSource", vo.getCustSource());
				model.addAttribute("custIndustry", vo.getCustIndustry());
				model.addAttribute("custLevel", vo.getCustLevel());
		return "mycustomer";
	}
	
	@RequestMapping(value="/mycustomer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		
		return myCustomerService.selectCustomerById(id);
		
	}
	
	@RequestMapping(value="/mycustomer/update.action")
	public @ResponseBody String update(Customer customer){
		myCustomerService.updateCustomerById(customer);
		return "OK";
		
	}
	
	@RequestMapping(value="/mycustomer/delete.action")
	public @ResponseBody String delete(Integer id){
		myCustomerService.deleteCustomerById(id);
		return "OK";
		
	}
}
