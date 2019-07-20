package com.atguigu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.atguigu.Impl.BookDaoImpl;
import com.atguigu.Impl.OrderAndUserDaoImpl;
import com.atguigu.bookdao.BookDao;
import com.atguigu.bookservicedao.bookServiceDao;
import com.atguigu.bookservicedao.bookservicedaoimpl.BookServiceDaoImpl;
import com.atguigu.entity.Book;
import com.atguigu.entity.OrderAndUser;
import com.atguigu.orderanduserdao.OrderAndUserDao;

public class BookDaoTest {
	BookDao bd = new BookDaoImpl();
	bookServiceDao bsd= new BookServiceDaoImpl();
	OrderAndUserDao oud = new OrderAndUserDaoImpl();
	@Test
	public void test() {
		List<OrderAndUser> orderAndUser = oud.getOrderAndUser();
		System.out.println(orderAndUser);
	}
	

}
