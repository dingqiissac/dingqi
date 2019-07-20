package com.atguigu.Impl;

import com.atguigu.bookservicedao.bookServiceDao;
import com.atguigu.dao.orderdao.OrderItemDao;
import com.atguigu.entity.Book;
import com.atguigu.entity.CartItemList;
import com.atguigu.entity.OrderItem;

import com.atguigu.userdao.BaseDao;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	@Override
	public int saveOrderItems(OrderItem oi) {
		String sql = "insert into OrderItem values "
				+ " (null,?,?,?,?,?,?,?)";
		
		return this.update(sql, 
				oi.getTitle(),
				oi.getAuthor(),
				oi.getPrice(),
				oi.getImgPath(),
				oi.getCount(),
				oi.getAmount(),
				oi.getOrderId());
	}

	
	

}
