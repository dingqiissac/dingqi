package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Impl.OrderAndUserDaoImpl;
import com.atguigu.Impl.OrderDaoImpl;
import com.atguigu.dao.orderdao.OrderDao;
import com.atguigu.entity.Order;
import com.atguigu.entity.OrderAndUser;
import com.atguigu.orderanduserdao.OrderAndUserDao;


public class OrderAndUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderAndUserDao oud = new OrderAndUserDaoImpl();
	private OrderDao od = new OrderDaoImpl();
	protected void findOrderAndUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderAndUser> orderAndUser = oud.getOrderAndUser();
		request.setAttribute("orderAndUser", orderAndUser);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
	
	protected void stateDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("order");
		od.updateOrder(orderid,1);
		response.sendRedirect(request.getContextPath()+"/OrderAndUserServlet?method=findOrderAndUser");
	}
	
	

}
