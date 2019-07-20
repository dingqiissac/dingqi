package com.atguigu.Impl;

import java.util.List;

import com.atguigu.dao.orderdao.OrderDao;
import com.atguigu.entity.Order;
import com.atguigu.userdao.BaseDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public int saveOrder(Order or) {
		String sql = "insert into orderlist "
				+ " values (?,?,?,?,?,?)";
		return this.update(sql, or.getId(),
				or.getCreateTime(),
				or.getTotalCount(),
				or.getTotalAmount(),
				or.getState(),
				or.getUserId());
	}

	@Override
	public List<Order> getAllOrderItemsByUserId(int userid) {
		String sql = "select * from orderlist where userId = ?";
		return this.getBeanList(Order.class, sql, userid);
	}

	@Override
	public Order getOne(String orderid) {
		String sql = "select * from orderlist where id = ?";
		return this.getBean(Order.class, sql, orderid);
	}

	@Override
	public void updateOrder(String orderid,int state) {
		String sql = "update orderlist set state = ? where id = ?";
		this.update(sql, state,orderid);
	}

}
