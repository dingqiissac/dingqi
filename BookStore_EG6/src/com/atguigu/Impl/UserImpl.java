package com.atguigu.Impl;

import com.atguigu.entity.User;
import com.atguigu.userdao.BaseDao;
import com.atguigu.userdao.UserDao;

public class UserImpl extends BaseDao implements UserDao {

	@Override
	public User getUser(String name, String password) {
		String sql = "select id,name,password,email from user where "
				+ "name = ? and "
				+ "password = ?";
		return this.getBean(User.class, sql, name,password);
	}

	@Override
	public int updateUser(User u) {
		String sql = "insert into user values(null,?,?,?)";
		return this.update(sql, u.getName(),u.getPassword(),u.getEmail());
	}

}
