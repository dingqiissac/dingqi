package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Impl.OrderDaoImpl;
import com.atguigu.bookservicedao.OrderServiceDao;
import com.atguigu.bookservicedao.bookservicedaoimpl.OrderServiceDaoImpl;
import com.atguigu.dao.orderdao.OrderDao;
import com.atguigu.entity.CartItemList;
import com.atguigu.entity.Order;
import com.atguigu.entity.User;


public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderServiceDao osd = new OrderServiceDaoImpl();
	private OrderDao od = new OrderDaoImpl();
	protected void payBill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("error", "请先登入再买单");
			request.getRequestDispatcher("/pages/user/login.jsp")
			.forward(request, response);
			return;
		}
		CartItemList CartItemList = (CartItemList)request.getSession().getAttribute("CartItemList");
		String id = osd.checkOut(CartItemList, user);
		request.setAttribute("orderid", id);
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
	}
	
	protected void checkBill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("error", "请先登入再买单");
			request.getRequestDispatcher("/pages/user/login.jsp")
			.forward(request, response);
			return;
		}
		List<Order> orlist = osd.getOrderItemsByUserId(user.getId());
		request.setAttribute("orderlist", orlist);
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	protected void stateDeliveryClint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("order");
		od.updateOrder(orderid,2);
		response.sendRedirect(request.getContextPath()+"/Order?method=checkBill");
	}
}
