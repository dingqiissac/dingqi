package com.atguigu.test;



import org.junit.Test;

import com.atguigu.Impl.UserImpl;
import com.atguigu.entity.User;
import com.atguigu.userdao.UserDao;

public class UserImplTest {

	@Test
	public void test() {
	UserDao userdao = new UserImpl();
	User s1 = userdao.getUser("丁奇", "123");
	System.out.println(s1);	
	}

}
