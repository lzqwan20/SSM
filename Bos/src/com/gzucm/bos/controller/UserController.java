package com.gzucm.bos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzucm.bos.pojo.User;
import com.gzucm.bos.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//登录
	@RequestMapping(value = "/User/login.action")
	public String login(String checkcode , User user ,HttpServletRequest request ,Model model){
		HttpSession session = request.getSession();
		String volidateCode = (String) session.getAttribute("key");
		if(StringUtils.isNotBlank(volidateCode) && checkcode.equals(volidateCode)){
			User existUser = userService.login(user);
			if(existUser == null){
				model.addAttribute("errorMesseage", "用户名或者密码不正确！！！！");
				return "login";
			}else {
				session.setAttribute("userId", existUser.getId());
				return "WEB-INF/pages/common/index";
			}
		}else{
			model.addAttribute("errorMesseage","验证码错误！！！！");
			return "login";
		}
	}
	@RequestMapping(value = "/User/editPassword.action")
	public @ResponseBody String editPassword(String password , HttpServletRequest request){
		String flat = "1";
		String userId = (String) request.getSession().getAttribute("userId");
		try {
			userService.editPassword(password,userId);
		} catch (Exception e) {
			flat = "0";
		}
		return flat;
	}
	@RequestMapping(value = "/User/toLogin.action")
	public String toLogin(){
		return "WEB-INF/pages/common/index";
	}
	@RequestMapping(value = "/User/page_common_home.action")
	public String page_common_home(){
		return "WEB-INF/pages/common/home";
	}
	@RequestMapping(value = "/User/page_portal_gonggao.action")
	public String page_portal_gonggao(){
		return "WEB-INF/pages/portal/gonggao";
	}
	@RequestMapping(value = "/User/page_portal_daiban.action")
	public String page_portal_daiban(){
		return "WEB-INF/pages/portal/daiban";
	}
	@RequestMapping(value = "/User/page_portal_yujing.action")
	public String page_portal_yujing(){
		return "WEB-INF/pages/portal/yujing";
	}
	@RequestMapping(value = "/User/page_portal_bug.action")
	public String page_portal_bug(){
		return "WEB-INF/pages/portal/bug";
	}
}
