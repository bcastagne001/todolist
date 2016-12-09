package fr.icdc.dei.todolist.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icdc.dei.todolist.persistence.dao.TaskDao;
import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.service.TaskService;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public List<Task> list() {
		return taskDao.findAll();
	}

	@Override
	public Task add(Task task) {
		if(task.getUser().getTasks().size() < 10)
			return taskDao.save(task);
		return null;
	}

	@Override
	public Task find(long id) {
		return taskDao.findOne(id);
	}

	@Override
	public boolean isEnded(Task task) {
		return task.getEndingDate() != null;
	}

	@Override
	public boolean previsionalEndingDateIsInAnIntervalOfDates(Task task, Date beginningIntervalDate, Date endingIntervalDate) {
		if(beginningIntervalDate.before(task.getPrevisionalEndingDate()) && endingIntervalDate.after(task.getPrevisionalEndingDate()))
			return true;
		else
			return false;
	}

	@Override
	public List<Task> listNotEndedUserTasksInAnIntervalOfDates(long idUser, Date beginningIntervalDate,	Date endingIntervalDate) {
		List<Task> tasksUser = taskDao.findAllByUserId(idUser);
		List<Task> validTasks = new ArrayList<Task>();
		
		for(Task task : tasksUser) {
			if(!isEnded(task) && previsionalEndingDateIsInAnIntervalOfDates(task, beginningIntervalDate, endingIntervalDate)) {
				validTasks.add(task);
			}
		}
		return validTasks;
	}

	@Override
	public void endAllTasksInList(List<Task> listNotEndedUserTasks) {
		for (Task task : listNotEndedUserTasks) {
			endTask(task);
		}
	}

	private void endTask(Task task) {
		task.setEndingDate(Calendar.getInstance().getTime());
		taskDao.save(task);		
	}

}
