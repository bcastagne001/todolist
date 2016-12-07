package fr.icdc.dei.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.persistence.dao.UserDao;

@Controller
@RequestMapping("/search")
public class SearchFormController {
	@Autowired
	private UserDao userDao;
	private Long userId = 1L;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listTasks() {
		ModelAndView page = new ModelAndView("SearchForm");
		page.addObject("userId", userId);
        page.addObject("user", userDao.findOne(userId));
		return page;
	}
}
