package com.atguigu.Impl;

import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.bookdao.BookDao;
import com.atguigu.entity.Book;
import com.atguigu.userdao.BaseDao;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public void saveBook(Book book) {
		String sql = "insert into book values(?,?,?,?,?,?,?)";
		this.update(sql, book.getId(),book.getTitle(),book.getAuthor(),
				book.getPrice(),book.getSales(),book.getStock(),
				book.getImgPath());
	}

	@Override
	public void deleteBook(String bookId) {
		String sql = "delete from book where id = ?";
		this.update(sql, bookId);
	}

	@Override
	public void updateBook(Book book) {
		String sql = "update book set title = ?,"
				+ "author = ?,"
				+ "price = ?,"
				+ "sales = ?,"
				+ "stock = ?,"
				+ "imgPath = ? where id = ?";
		this.update(sql, book.getTitle(),book.getAuthor(),
				book.getPrice(),book.getSales(),
				book.getStock(),book.getImgPath(),book.getId());
	}

	@Override
	public Book getBookById(String bookId) {
		String sql = "select * from book where id = ?";
		return this.getBean(Book.class, sql, bookId);
	}

	@Override
	public List<Book> getBookList() {
		String sql = "select * from book";
		return this.getBeanList(Book.class, sql);
	}

	@Override
	public Integer getTotalRecodes() {
		String sql = "select count(id) from book";
		Object i =  this.getScalar(sql);
		long u = (long)i;
		return (int)u;
	}

	@Override
	public List<Book> getBookList(int offset, int limit) {
		String sql = "select * from book limit ? , ?";
		return this.getBeanList(Book.class, sql, offset,limit);
	}

	@Override
	public int getTotalRecodes(int min, int max) {
		String sql = "select count(*) from book where 1=1";
		if(min != -1 && max == -1) {
			sql+=" and price >= ?";
			long y = (long)this.getScalar(sql, min);
			return (int)y;
		}
		
		if(max != -1 && min == -1){
			sql+=" and price <= ?";
			long y = (long)this.getScalar(sql, max);
			return (int)y;
		}
		
		if(max!=-1 && min!=-1){
			sql+=" and price >= ? and price <= ?";
			long y = (long)this.getScalar(sql, min,max);
			return (int)y;
		}
		
		long y = (long)this.getScalar(sql);
		return (int)y;
	}

	@Override
	public List<Book> getBookList(Integer beginPageOffset, int limit, int min, int max) {
		String sql = "select * from book where 1=1";
		if(min != -1 && max == -1) {
			sql+=" and price >= ? order by price limit ? , ? ";
			List<Book> l = this.getBeanList(Book.class, sql, min,beginPageOffset,limit);
			return l;
		}
		
		if(max != -1 && min == -1){
			sql+=" and price <= ? order by price limit ? , ?";
			List<Book> l = this.getBeanList(Book.class, sql, max,beginPageOffset,limit);
			return l;
		}
		
		if(max!=-1 && min!=-1){
			sql+=" and price >= ? and price <= ? order by price limit ? , ?";
			List<Book> l = this.getBeanList(Book.class, sql, min,max,beginPageOffset,limit);
			return l;
		}
		
		sql+=" order by price limit ? , ? ";
		List<Book> l = this.getBeanList(Book.class, sql, beginPageOffset,limit);
		return l;
	}

	
}
