package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;


public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(StringUtils.isEmpty(method)) {
			method = "index";
		}
		Class c =  this.getClass();
		
		
		try {
			Method m = c.getDeclaredMethod
					(method, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
