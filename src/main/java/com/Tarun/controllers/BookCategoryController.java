package com.Tarun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Tarun.entities.BookCategory;
import com.Tarun.services.BookCategoryService;

@Controller
@RequestMapping("book-management")
public class BookCategoryController {

	@Autowired
	private BookCategoryService bookCategoryService;
	
	@RequestMapping("category-list")
	public String updateCategory(Model model) {
		List<BookCategory> categoryList= bookCategoryService.getAllBookCategoryList();
		model.addAttribute("clist", categoryList);
		return "category/category-list";
	}
	
	@RequestMapping("add-category")
	public String addBookCategoryView() {
		return "category/add-category";
	}
	
	@RequestMapping("save-category")
	public ModelAndView saveBookCategory(BookCategory cat,Model model) {
		BookCategory cat1= bookCategoryService.getBookCategoryByName(cat.getCategory());
		if(cat1!=null) {
//			model.addAttribute("msg", "Category already exists!");
			return new ModelAndView("redirect:/book-management/add-category");
		}
		bookCategoryService.saveBookCategory(cat);
		return new ModelAndView("redirect:/book-management/category-list");
	}
	
	@RequestMapping("edit-category")
	public String editBookCategory(@RequestParam int cid,Model model) {
		model.addAttribute("cat", bookCategoryService.getBookCategory(cid));
		return "category/edit-category";
	}
	
	@RequestMapping("update-category")
	public ModelAndView updateCategory(BookCategory cat) {
		bookCategoryService.updateCategory(cat);
		return new ModelAndView("redirect:/book-management/category-list");
	}
	
	@RequestMapping("remove-category")
	public ModelAndView removeCategory(@RequestParam int cid) {
		bookCategoryService.removeCategory(cid);
		return new ModelAndView("redirect:/book-management/category-list");
	}
	
	
}
