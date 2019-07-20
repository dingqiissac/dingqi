package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Impl.BookDaoImpl;
import com.atguigu.bookdao.BookDao;
import com.atguigu.entity.Book;
import com.atguigu.entity.CartItem;
import com.atguigu.entity.CartItemList;

/**
 * Servlet implementation class cartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookDao bd = new BookDaoImpl();
	IndexServlet in = new IndexServlet();

	protected void addBook2Cart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		CartItemList CartItemList = (CartItemList) request.getSession().getAttribute("CartItemList");
		Book book = bd.getBookById(bookid);

		if (CartItemList == null) {
			CartItemList = new CartItemList();
			CartItem ci = new CartItem();
			ci.setBook(book);
			ci.setQuantity(1);
			CartItemList.getM().put(Integer.valueOf(bookid), ci);
			request.getSession().setAttribute("CartItemList", CartItemList);
		} else {
			CartItem cartItem = CartItemList.getM().get(Integer.valueOf(bookid));
			if (cartItem == null) {
				cartItem = new CartItem();
				cartItem.setBook(book);
				cartItem.setQuantity(1);
				CartItemList.getM().put(Integer.valueOf(bookid), cartItem);
			} else {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
			}
		}

		in.findPage(request, response);

	}
	
	protected void reduceOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartItemList CartItemList = (CartItemList)request.getSession().getAttribute("CartItemList");
		String bookid = request.getParameter("bookid");
		CartItem cartItem = CartItemList.getM().get(Integer.valueOf(bookid));
		if(cartItem.getQuantity()-1>0) {
			cartItem.setQuantity(cartItem.getQuantity()-1);
		}else {
			cartItem.setQuantity(1);
		}
		
		
		request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request, response);
	}
	
	protected void addOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartItemList CartItemList = (CartItemList)request.getSession().getAttribute("CartItemList");
		String bookid = request.getParameter("bookid");
		CartItem cartItem = CartItemList.getM().get(Integer.valueOf(bookid));
		
		cartItem.setQuantity(cartItem.getQuantity()+1);
		
		
		request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request, response);
	}
	
	protected void inputQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartItemList CartItemList = (CartItemList)request.getSession().getAttribute("CartItemList");
		String bookid = request.getParameter("bookid");
		String quantity = request.getParameter("quantity");
		CartItem cartItem = CartItemList.getM().get(Integer.valueOf(bookid));
		
		cartItem.setQuantity(Integer.valueOf(quantity));
		
		
		request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request, response);
	}
	
	protected void deleteOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CartItemList CartItemList = (CartItemList)request.getSession().getAttribute("CartItemList");
		String bookid = request.getParameter("bookid");
		CartItemList.getM().remove(Integer.valueOf(bookid));      
		request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request, response);
	}
	
	
	
}
