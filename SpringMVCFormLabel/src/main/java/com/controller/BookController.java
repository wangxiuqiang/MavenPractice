package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.domain.Book;
import com.domain.Category;
import com.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	private static final Log logger = LogFactory.getLog(BookController.class);
   
	@RequestMapping(value = "/book_input")
    public String inputBook(Model model){
    	List<Category> categories = bookService.getAllCategories();
    	model.addAttribute("categories",categories);
    	model.addAttribute("book",new Book());
    	return "BookAddForm";
    }
    
    @RequestMapping(value="/book_edit/{id}")
    public String editBook(Model model , @PathVariable long id ){
    	List<Category> categories = bookService.getAllCategories();
    	model.addAttribute("categories",categories);
    	Book book = bookService.get(id);//通过id寻找要更改的书的类
    	model.addAttribute("book", book);
    	return "BookEditForm";
    }
    
    @RequestMapping(value = "/book_save")
    public String saveBook(@ModelAttribute Book book){//将输入的book添加到Model
    	/**
    	 * 根据输入的book的category的id值获取category，
    	 * 并且添加进入
    	 */
    	Category category = bookService.getCategory(book.getCategory().getId());
    	book.setCategory(category);
    	bookService.save(book);
    	return "redirect:/book_list";
    }
    
    @RequestMapping(value = "/book_update")
    public String updateBook(@ModelAttribute Book book){
    	/**
    	 * 获取category 更新书籍的category 
    	 */
//    	System.out.println("dsfsdfds");
    	Category category = bookService.getCategory(book.getCategory().getId());
    	book.setCategory(category);
    	bookService.update(book);
    	return "redirect:/book_list";
    }
    
    @RequestMapping(value = "/book_list")
    public String listBooks(Model model){
    	logger.info("book_list");
    	List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookList";
    }
}
