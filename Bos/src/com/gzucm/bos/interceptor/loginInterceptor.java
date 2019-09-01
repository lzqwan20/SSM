package com.gzucm.bos.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class loginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object arg2) throws Exception {
		//不拦截login方法
		String URI = Request.getRequestURI();
		if(URI.indexOf("login") >= 0){
			return true;
		}
		//已经登录放行
		HttpSession session = Request.getSession();
		Object userId = session.getAttribute("userId");
		if(userId != null){
			//放行
			return true;
		}
		//不符合条件的给出提示信息，并转发到登录页面
	    Request.setAttribute("errorMesseage", "您还没有登录，请先登录！");
		Request.getRequestDispatcher("/login.jsp").forward(Request, Response);
		return false;
	}

}
