package com.atguigu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Impl.BookDaoImpl;
import com.atguigu.Impl.UserImpl;
import com.atguigu.bookdao.BookDao;
import com.atguigu.entity.User;
import com.atguigu.userdao.UserDao;

/**
 * Servlet implementation class AllServlet
 */
public class UserServlet extends BaseServlet {
	private UserDao udao = new UserImpl();//userdao
	private BookDao bd = new BookDaoImpl();//bookdao
	protected void logOut(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/index");
	}
	//1.userdao操作
	protected void Login(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = udao.getUser(username, password);
		System.out.println(user);
		if(user==null) {
			request.setAttribute("error", "登入失败");
			request.getRequestDispatcher("/pages/user/login.jsp")
			.forward(request, response);
			
		}else {
			System.out.println("登入成功");
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	
	protected void Regist(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String codewrite = request.getParameter("code");
		String code = (String)request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
		
		if(!code.equalsIgnoreCase(codewrite)) {
			request.setAttribute("error", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		User u = new User(null, username, password, email);
		
		int y = udao.updateUser(u);
		
		if(y==1) {
			System.out.println("success");
			request.getSession().setAttribute("user", u);
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}else {
			request.setAttribute("error", "注册失败");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
		
	}
	
}
