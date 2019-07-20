package com.atguigu.bookdao;

import com.atguigu.entity.Book;

public interface BookMapper {
	public void saveBook(Book book);
	public void deleteBook(String bookId); 
	public void updateBook(Book book);
	public Book getBookById(String bookId); 
}
