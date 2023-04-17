package com.Tarun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Tarun.entities.Book;
import com.Tarun.entities.BookCategory;
import com.Tarun.entities.BookPublisher;
import com.Tarun.services.BookCategoryService;
import com.Tarun.services.BookPublisherService;
import com.Tarun.services.BookService;

@Controller
@RequestMapping("book-management")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookCategoryService bookCategoryService;
	@Autowired
	private BookPublisherService bookPublisherService;

	@RequestMapping("login")
	public String loginView() {
		return "home/login";
	}
	@RequestMapping("login-check")
	public String loginCheck(@RequestParam String username,@RequestParam String password,Model model) {
		System.out.println(username+" "+password);
		if(username.equals("tarun") && password.equals("tarun@123")) {
			return "home/home-page";
		}
		model.addAttribute("msg","Invalid username or password");
		return  "home/login";
	}
	@RequestMapping("home")
	public String getHomeView() {
		return "home/home-page";
	}

	@RequestMapping("book-list")
	public String openBookList(Model model) {
		List<Book> book = bookService.getAllBooks();
		model.addAttribute("blist", book);
		return "book/book-list";
	}

	@RequestMapping("add-book")
	public String addBook(Model model) {
		List<BookCategory> bookCategories = bookCategoryService.getAllBookCategoryList();
		List<BookPublisher> bookPublishers = bookPublisherService.getAllBookPublisherList();
		model.addAttribute("clist", bookCategories);
		model.addAttribute("plist", bookPublishers);

		return "book/add-book";
	}

	@RequestMapping("save-book")
	public ModelAndView saveBook(Book book) {
		bookService.saveBook(book);
		return new ModelAndView("redirect:/book-management/book-list");
	}

	@RequestMapping("edit-book")
	public String editBook(@RequestParam int bid, Model model) {
		Book book = bookService.getBookById(bid);
		model.addAttribute("book", book);
		List<BookCategory> bookCategories = bookCategoryService.getAllBookCategoryList();
		List<BookPublisher> bookPublishers = bookPublisherService.getAllBookPublisherList();
		model.addAttribute("clist", bookCategories);
		model.addAttribute("plist", bookPublishers);

		return "book/edit-book";
	}

	@RequestMapping("remove-book")
	public ModelAndView removeBook(@RequestParam int bid) {
		bookService.removeBook(bid);
		return new ModelAndView("redirect:/book-management/book-list");
	}

	@RequestMapping("update-book")
	public ModelAndView updateBook(Book book) {
		bookService.updateBook(book);
		return new ModelAndView("redirect:/book-management/book-list");
	}

	@RequestMapping("search-book")
	public String searchBookView(Model model) {
		List<BookCategory> bookCategories = bookCategoryService.getAllBookCategoryList();
		List<BookPublisher> bookPublishers = bookPublisherService.getAllBookPublisherList();
		model.addAttribute("clist", bookCategories);
		model.addAttribute("plist", bookPublishers);
		return "search/search-books";
	}

	@RequestMapping("search-book/byid")
	public String searchBookById(@RequestParam int bid, Model model) {
		List<Book> list = bookService.getAllBooksById(bid);
		model.addAttribute("blist", list);
		model.addAttribute("by", "Id");
		return "search/book-list";

	}

	@RequestMapping("search-book/byauthor")
	public String searchBookByAuthor(@RequestParam String author, Model model) {
		List<Book> list = bookService.getAllBooksByAuthor(author);
		model.addAttribute("blist", list);
		model.addAttribute("by", "Author");
		return "search/book-list";
	}

	@RequestMapping("search-book/bytitle")
	public String searchBookByTitle(@RequestParam String title, Model model) {
		List<Book> list = bookService.getAllBooksByTitle(title);
		model.addAttribute("blist", list);
		model.addAttribute("by", "Title");
		return "search/book-list";
	}

	@RequestMapping("search-book/bycategory")
	public String searchBookByCategory(@RequestParam int cid, Model model) {
		BookCategory cat = bookCategoryService.getBookCategory(cid);
		List<Book> list = bookService.getAllBooksByCatid(cat);
		model.addAttribute("blist", list);
		model.addAttribute("by", "Category");
		return "search/book-list";
	}

	@RequestMapping("search-book/bypublisher")
	public String searchBookByPublisher(@RequestParam int pubid, Model model) {
		BookPublisher pub = bookPublisherService.getBookPublisherById(pubid);
		List<Book> list = bookService.getAllBooksByPubid(pub);
		model.addAttribute("blist", list);
		model.addAttribute("by", "Publisher");
		return "search/book-list";
	}
}
