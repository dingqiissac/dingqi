package com.atguigu.userdao;

import com.atguigu.entity.User;

public interface UserDao {
     User getUser(String name,String password);
     
     int updateUser(User u);
}
