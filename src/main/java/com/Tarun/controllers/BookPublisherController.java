package com.Tarun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Tarun.entities.BookCategory;
import com.Tarun.entities.BookPublisher;
import com.Tarun.services.BookPublisherService;

@Controller
@RequestMapping("book-management")
public class BookPublisherController {

	@Autowired
	private BookPublisherService bookPublisherService;
	
	@RequestMapping("publisher-list")
	public String updatePublisher(Model model) {
		List<BookPublisher> list= bookPublisherService.getAllBookPublisherList();
		model.addAttribute("plist", list);
		return "publisher/publisher-list";
	}
	
	@RequestMapping("add-publisher")
	public String addBookPublisherView() {
		return "publisher/add-publisher";
	}
	
	@RequestMapping("save-publisher")
	public ModelAndView saveBookPublisher(BookPublisher cat,Model model) {
		BookPublisher cat1= bookPublisherService.getBookPublisherById(cat.getPubid());
		if(cat1!=null) {
			return new ModelAndView("redirect:/book-management/add-publisher");
		}
		bookPublisherService.saveBookPublisher(cat);
		return new ModelAndView("redirect:/book-management/publisher-list");
	}
	
	@RequestMapping("edit-publisher")
	public String editBookCategory(@RequestParam int pid,Model model) {
		model.addAttribute("pub", bookPublisherService.getBookPublisherById(pid));
		return "publisher/edit-publisher";
	}
	
	@RequestMapping("update-publisher")
	public ModelAndView updatePublisher(BookPublisher cat) {
		bookPublisherService.updatePublisher(cat);
		return new ModelAndView("redirect:/book-management/publisher-list");
	}
	
	@RequestMapping("remove-publisher")
	public ModelAndView removePublisher(@RequestParam int pid) {
		bookPublisherService.removeCategory(pid);
		return new ModelAndView("redirect:/book-management/publisher-list");
	}
	
	
}
