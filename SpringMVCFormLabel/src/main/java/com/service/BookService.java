package com.service;

import java.util.List;

import com.domain.Book;
import com.domain.Category;

public interface BookService {
	List<Category>  getAllCategories();
    Category getCategory(int id);//通过id获取指定的category
    List<Book> getAllBooks();//获取全部的书
    Book save(Book book);//保存书
    Book update(Book book);  //更新书
    Book get(int id);//通过id来找书
    long getNextId();//获取下一本书的id，用来添加书时自动给书赋id
}
