package fr.icdc.dei.todolist.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	private Date beginningIntervalDate;
	private Date endingIntervalDate;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listTasks() {
		ModelAndView page = new ModelAndView("Tasks");
		page.addObject("tasks", taskService.list());
		return page;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView searchTasks() {
		ModelAndView page = new ModelAndView("SearchForm");
		return page;
	}
	
	@RequestMapping(value="/results", method=RequestMethod.POST)
	public ModelAndView listNotEndedUserTasksInAnIntervalOfDates(@RequestParam long userId, @RequestParam Date beginningIntervalDate, @RequestParam Date endingIntervalDate) {
		this.beginningIntervalDate = beginningIntervalDate;
		this.endingIntervalDate = endingIntervalDate;
		
		ModelAndView page = new ModelAndView("ResultSearch");
		page.addObject("tasks", taskService.listNotEndedUserTasksInAnIntervalOfDates(userId, beginningIntervalDate, endingIntervalDate));
		page.addObject("userId", userId);
		return page;
	}
	
	@RequestMapping(value="/endAllTasks/{userId}", method=RequestMethod.POST)
	public ModelAndView endAllTasksInList(@PathVariable long userId) {
		taskService.endAllTasksInList(taskService.listNotEndedUserTasksInAnIntervalOfDates(userId, beginningIntervalDate, endingIntervalDate));
		return new ModelAndView("redirect:" + "/tasks");
	}
}
