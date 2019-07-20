package com.atguigu.bookservicedao.bookservicedaoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atguigu.Impl.OrderDaoImpl;
import com.atguigu.Impl.OrderItemDaoImpl;
import com.atguigu.bookservicedao.OrderServiceDao;
import com.atguigu.bookservicedao.bookServiceDao;
import com.atguigu.dao.orderdao.OrderDao;
import com.atguigu.dao.orderdao.OrderItemDao;
import com.atguigu.entity.CartItem;
import com.atguigu.entity.CartItemList;
import com.atguigu.entity.Order;
import com.atguigu.entity.OrderItem;
import com.atguigu.entity.User;

public class OrderServiceDaoImpl implements OrderServiceDao {
	private OrderDao od = new OrderDaoImpl();
	private OrderItemDao oid = new OrderItemDaoImpl();
	private bookServiceDao bsd = new BookServiceDaoImpl();

	@Override
	public String checkOut(CartItemList list, User u) {
		Order or = new Order();
		Date time = new Date();
		String id = time.getTime() + "" + u.getId();
		or.setId(id);
		or.setCreateTime(time);
		or.setState(0);
		or.setTotalAmount(list.getAllAmount());
		or.setTotalCount(list.getCountNumber());
		or.setUserId(u.getId());
		od.saveOrder(or);

		ArrayList<CartItem> l = new ArrayList<>(list.getM().values()) ;
		for (CartItem ca : l) {
			OrderItem oi = new OrderItem();
			oi.setTitle(ca.getBook().getTitle());
			oi.setPrice(ca.getBook().getPrice());
			oi.setOrderId(id);
			oi.setImgPath(ca.getBook().getImgPath());
			oi.setCount(ca.getQuantity());
			oi.setAmount(ca.getTotalAmount());
			oi.setAuthor(ca.getBook().getAuthor());
			oid.saveOrderItems(oi);
			bsd.modifyStock(ca.getBook().getId(), ca.getQuantity());
		}

		list.getM().clear();
		return id;
	}

	@Override
	public List<Order> getOrderItemsByUserId(int userid) {
		return od.getAllOrderItemsByUserId(userid);
	}

}
