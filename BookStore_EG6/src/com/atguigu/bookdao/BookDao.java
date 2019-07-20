package com.atguigu.bookdao;

import java.util.List;

import com.atguigu.entity.Book;

public interface BookDao {
	public void saveBook(Book book);
	public void deleteBook(String bookId); 
	public void updateBook(Book book);
	public Book getBookById(String bookId); 
	public List<Book> getBookList(); 
	public Integer getTotalRecodes();
	public List<Book> getBookList(int offset,int limit);
	public int getTotalRecodes(int min, int max);
	public List<Book> getBookList(Integer beginPageOffset, int limit, int min, int max);
	
}
