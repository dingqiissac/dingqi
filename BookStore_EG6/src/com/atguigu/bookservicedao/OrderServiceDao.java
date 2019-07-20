package com.atguigu.bookservicedao;

import java.util.List;

import com.atguigu.entity.CartItemList;
import com.atguigu.entity.Order;
import com.atguigu.entity.User;

public interface OrderServiceDao {
     String checkOut(CartItemList list, User u);
     public List<Order> getOrderItemsByUserId(int userid);
}
