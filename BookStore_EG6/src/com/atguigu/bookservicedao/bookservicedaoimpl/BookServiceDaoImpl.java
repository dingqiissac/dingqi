package com.atguigu.bookservicedao.bookservicedaoimpl;

import java.util.List;

import com.atguigu.Impl.BookDaoImpl;
import com.atguigu.bookdao.BookDao;
import com.atguigu.bookservicedao.bookServiceDao;
import com.atguigu.entity.Book;
import com.atguigu.entity.Page;

public class BookServiceDaoImpl implements bookServiceDao {
       private BookDao bd = new BookDaoImpl();
	@Override
	public Page<Book> findpage(int pageNumber, int limit) {
		Page<Book> p = new Page<>();
		p.setPageNumber(pageNumber);
		p.setLimit(limit);
		int totalRecodes = bd.getTotalRecodes();
		p.setTotalRecodes(totalRecodes);
		List<Book> l = bd.getBookList(p.getBeginPageOffset(), limit);
		p.setData(l);
		return p;
	}
	@Override
	public Page<Book> findpage(int pageNumber, int limit, int min, int max) {
		Page<Book> p = new Page<>();
		p.setPageNumber(pageNumber);
		p.setLimit(limit);
		int totalRecodes = bd.getTotalRecodes(min,max);
		p.setTotalRecodes(totalRecodes);
		List<Book> l = bd.getBookList(p.getBeginPageOffset(), limit,min,max);
		p.setData(l);
		return p;
	}
	@Override
	public void modifyStock(Integer id, int quantity) {
		Book b = bd.getBookById(String.valueOf(id));
		b.setStock(b.getStock()-quantity);
		bd.updateBook(b);
	}

}
