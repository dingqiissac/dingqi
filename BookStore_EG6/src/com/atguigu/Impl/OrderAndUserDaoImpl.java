package com.atguigu.Impl;

import java.util.List;

import com.atguigu.entity.OrderAndUser;
import com.atguigu.orderanduserdao.OrderAndUserDao;
import com.atguigu.userdao.BaseDao;

public class OrderAndUserDaoImpl extends BaseDao implements OrderAndUserDao {

	@Override
	public List<OrderAndUser> getOrderAndUser() {
		String sql = "SELECT `orderlist`.`id`,`orderlist`.`createTime`,`orderlist`.`totalCount`,`orderlist`.`totalAmount`,`orderlist`.`state`,\r\n" + 
				"`orderlist`.`userId` ,`user`.`name`,`user`.`email` FROM `orderlist` INNER JOIN `user` ON \r\n" + 
				"`orderlist`.`userId` = `user`.`id`";
		return this.getBeanList(OrderAndUser.class, sql);
	}

}
