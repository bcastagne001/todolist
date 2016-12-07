package fr.icdc.dei.todolist.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.service.TaskService;

@Controller
@RequestMapping("/results")
public class ResultSearchController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listNotEndedUserTasksInAnIntervalOfDates(@RequestParam long userId, @RequestParam Date beginningIntervalDate, @RequestParam Date endingIntervalDate) {
		ModelAndView page = new ModelAndView("ResultSearch");
		page.addObject("tasks", taskService.listNotEndedUserTasksInAnIntervalOfDates(userId, beginningIntervalDate, endingIntervalDate));
		return page;
	}
}
