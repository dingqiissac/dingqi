package com.atguigu.bookservicedao;

import com.atguigu.entity.Book;
import com.atguigu.entity.Page;

public interface bookServiceDao {
    Page<Book> findpage(int pageNumber,int limit);

	Page<Book> findpage(int pageNumber, int limit, int min, int max);
	
	void modifyStock(Integer id, int quantity);
}
