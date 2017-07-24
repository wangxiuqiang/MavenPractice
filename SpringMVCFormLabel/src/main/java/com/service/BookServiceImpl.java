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

	public BookServiceImpl() {// 初始化List<E>
		categories = new ArrayList<Category>();
		Category category1 = new Category(1, "Computing");
		Category category2 = new Category(2, "Travel");
		Category category3 = new Category(3, "Health");// name属性相当于标签
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);

		books = new ArrayList<Book>();
		books.add(new Book(1L, "9780980839623", "Servlet & JSP:A Tutorial", category1, "Budi Kurnuawan"));
		books.add(new Book(2L, "9780980839630", "C#:A Beginner's Tutorial", category1, "Jayden Ky"));
	}

	@Override
	public Category getCategory(int id) {
        for(Category category : categories){
        	if(id == category.getId()){
        		return category ;
        	}
        }
		return null;
	}

	@Override
	public Book save(Book book) {
		book.setId(getNextId());//获取新的书籍的编号
		books.add(book);//加入List数组
		return book;
	}

	@Override
	public Book update(Book book) {//通过for循环找到要更新的值，进行更新
		int bookCount = books.size();
		for(int i = 0; i < bookCount;i ++){
			Book saveBook = books.get(i);
			if(saveBook.getId() == book.getId()){
				books.set(i, book);
				return book;
			}
		}
		return null;
	}

	@Override
	public Book get(long id) {// 通过id获取book对象
		for (Book book : books) {
			if (id == book.getId()) {
				return book;
			}
		}
		return null;
	}

	@Override
	public long getNextId() {// 通过foreach循环遍历，把id添加到最后一个产生新的id
		long id = 0L;
		for (Book book : books) {
			long bookid = book.getId();
			if (bookid > id) {
				id = bookid;
			}
		}
		return id + 1;
	}

	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	@Override
	public List<Book> getAllBooks() {
		return books;
	}

}
