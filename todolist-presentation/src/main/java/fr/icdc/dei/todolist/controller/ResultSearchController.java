package fr.icdc.dei.todolist.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.persistence.dao.UserDao;
import fr.icdc.dei.todolist.service.TaskService;

@Controller
@RequestMapping("/results")
public class ResultSearchController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserDao userDao;

	private long userId;
	private Date beginningIntervalDate;
	private Date endingIntervalDate;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listTasks() {
		ModelAndView page = new ModelAndView("ResultSearch");
		page.addObject("tasks", taskService.listNotEndedUserTasksInAnIntervalOfDates(userId, beginningIntervalDate, endingIntervalDate));
		return page;
	}

}
