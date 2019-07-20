package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.Impl.BookDaoImpl;
import com.atguigu.bookdao.BookDao;
import com.atguigu.bookservicedao.bookServiceDao;
import com.atguigu.bookservicedao.bookservicedaoimpl.BookServiceDaoImpl;
import com.atguigu.entity.Book;
import com.atguigu.entity.Page;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private BookDao bd = new BookDaoImpl();
	private bookServiceDao bsd = new BookServiceDaoImpl();
	protected void index(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException {
		findPage(request,response);
	}
	
	//2.bookdao操作
		//获取图书列表的方法
		protected void getBookList(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			List<Book> bookList = bd.getBookList();
			
			request.setAttribute("booklist", bookList);
			
			request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request, response);
		}
		//添加图书的方法
		protected void addOneBook(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			String title = request.getParameter("book_name");
			String price = request.getParameter("book_price");
			String author = request.getParameter("book_author");
			String sales = request.getParameter("book_sales");
			String stock = request.getParameter("book_amount");
			title = new String(title.getBytes("ISO8859-1"), "UTF-8");
			byte[] b1 = author.getBytes("ISO8859-1");
			author = new String(b1, "UTF-8");
			Book book = new Book(null, title, author, Double.valueOf(price), 
					Integer.valueOf(sales), Integer.valueOf(stock));
			bd.saveBook(book);
			
			response.sendRedirect("BookServlet?method=findPage");
		}
		//删除图书的方法
		protected void deleteOneBook(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			String idstr = request.getParameter("id");
			
			bd.deleteBook(idstr);
			
			response.sendRedirect("BookServlet?method=findPage");
		}
		//编辑图书的方法
		protected void editOneBook(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			String id = request.getParameter("id");
			
			if(id==""){
				addOneBook(request,response);
				return;
			}
			String title = request.getParameter("book_name");
			String price = request.getParameter("book_price");
			String author = request.getParameter("book_author");
			String sales = request.getParameter("book_sales");
			String stock = request.getParameter("book_amount");
			
			title = new String(title.getBytes("ISO8859-1"), "UTF-8");
			byte[] b1 = author.getBytes("ISO8859-1");
			author = new String(b1, "UTF-8");
			Book b = new Book(Integer.valueOf(id), title, author, 
					Double.valueOf(price), Integer.valueOf(sales), Integer.valueOf(stock));
			
			bd.updateBook(b);
			
			response.sendRedirect("book?method=findPage");
			
		}
		//保存或者更新图书的方法
		protected void saveOrUpdate(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			
		}
		//获取一本书
		protected void getOneBook(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException {
			String id = request.getParameter("id");
			Book b = bd.getBookById(id);
			request.setAttribute("book", b);
			request.getRequestDispatcher("pages/manager/book_edit.jsp").forward(request, response);
		}
		//manager分页
		protected void findPage(HttpServletRequest request, 
				HttpServletResponse response)throws ServletException, IOException { 
			String pageNumberstr = request.getParameter("pageNumber");
			
			int pageNumber = 1;
			if(pageNumberstr!=null) {
				pageNumber = Integer.parseInt(pageNumberstr);
			}
			
			int limit = 5;
			
			Page<Book> page = bsd.findpage(pageNumber, limit);
			request.setAttribute("page", page);
			request.getRequestDispatcher("pages/manager/book_manager.jsp")
			.forward(request, response);
		}
	
}
