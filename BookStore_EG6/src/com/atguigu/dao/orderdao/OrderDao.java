package com.atguigu.dao.orderdao;

import java.util.List;

import com.atguigu.entity.CartItemList;
import com.atguigu.entity.Order;

public interface OrderDao {
     int saveOrder(Order or);
     List<Order> getAllOrderItemsByUserId(int userid);
	 Order getOne(String orderid);
	 void updateOrder(String orderid,int state);
}
