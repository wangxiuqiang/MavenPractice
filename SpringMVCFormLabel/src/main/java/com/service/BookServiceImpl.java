package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.Book;
import com.domain.Category;

@Service
public class BookServiceImpl implements BookService {

	private List<Category> categories;
	private List<Book> books;
	
	 public BookServiceImpl() {//初始化List<E>
		categories = new ArrayList<Category>();
		Category category1 = new Category(1,"Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3,"Health");//name属性相当于标签
	    categories.add(category1);
	    categories.add(category2);
	    categories.add(category3);
	    
	    books = new ArrayList<Book>();
	    books.add(new Book(1L,"9780980839623","Servlet & JSP:A Tutorial",category1,"Budi Kurnuawan"));
	    books.add(new Book(2L,"9780980839630","C#:A Beginner's Tutorial",category1,"Jayden Ky"));
	 }
	@Override
	public Category getCategory(int id) {
		
		return null;
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNextId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public java.util.List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
