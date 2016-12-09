package fr.icdc.dei.todolist.service;

import java.util.Date;
import java.util.List;
import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskService {

	List<Task> list();

	Task add(Task task);

	Task find(long id);

	boolean isEnded(Task task);

	boolean previsionalEndingDateIsInAnIntervalOfDates(Task task, Date beginningIntervalDate, Date endingIntervalDate);

	List<Task> listNotEndedUserTasksInAnIntervalOfDates(long idUser, Date beginningIntervalDate, Date endingIntervalDate);

	void endAllTasksInList(List<Task> listNotEndedUserTasks);

}
