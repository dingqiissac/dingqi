package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.bookservicedao.bookServiceDao;
import com.atguigu.bookservicedao.bookservicedaoimpl.BookServiceDaoImpl;
import com.atguigu.entity.Book;
import com.atguigu.entity.Page;


public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private bookServiceDao bsd = new BookServiceDaoImpl();
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		findPage(request,response);
	}
	
	protected void findPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String minstr = request.getParameter("min");
		String maxstr = request.getParameter("max");
		int min = -1;
		int max = -1;
		if(!StringUtils.isEmpty(minstr)) {
			min = Integer.parseInt(minstr);
		}
		if(!StringUtils.isEmpty(maxstr)) {
			max = Integer.parseInt(maxstr);
		}
		
		String pageNumberstr = request.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberstr!=null) {
			pageNumber = Integer.parseInt(pageNumberstr);
		}
		
		int limit = 4;
		Page<Book> page = bsd.findpage(pageNumber, limit,  min,  max);
		/*Page<Book> page = bsd.findpage(pageNumber, limit);*/
		request.setAttribute("page", page);
		request.getRequestDispatcher("/index.jsp")
		.forward(request, response);
	}

}
