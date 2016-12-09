package fr.icdc.dei.todolist.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.collections.CollectionUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.User;
import fr.icdc.dei.todolist.persistence.entity.UserFree;

public class TaskServiceTest extends AbstractServiceTest {
	
	private static final long ID_USER_END_ALL_TASKS = 4L;
	private static final int INTERVAL_DATE_MONTH = 10;
	private static final int INTERVAL_DATE_YEAR = 2016;
	private static final long ID_TASK_ENDING_IN_AN_INTERVAL_OF_DATES = 6L;
	private static final long ID_TASK_NOT_ENDED = 5L;
	private static final long ID_TASK_ENDED = 4L;
	private static final String TASK_LABEL = "taskLabel";
	private static final long ID_USER = 3L;
	private static Date BEGINNING_INTERVAL_DATE;
	private static Date ENDING_INTERVAL_DATE;

	private final static Task task = new Task();
	private final static User user = new UserFree();


	@Autowired
	private TaskService taskService;
	
	@BeforeClass
	public static void setUp() {
		task.setLabel(TASK_LABEL);
		user.setId(2L);
		task.setUser(user);
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(INTERVAL_DATE_YEAR, INTERVAL_DATE_MONTH, 14);
		BEGINNING_INTERVAL_DATE = calendar.getTime();
		calendar.set(INTERVAL_DATE_YEAR, INTERVAL_DATE_MONTH, 25);
		ENDING_INTERVAL_DATE = calendar.getTime();
	}

	@Test
	public void testListTasks() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.list()));
	}
	
	@Test
	public void testAddTaskSucceedWithLessThanTenTasksForFreeUser() {
		assertNotNull(taskService.add(task));
	}
	
	@Test
	public void testEndedTaskIsEnded() {
		assertTrue(taskService.isEnded(taskService.find(ID_TASK_ENDED)));
	}
	
	@Test
	public void testNotEndedTaskIsNotEnded() {
		assertFalse(taskService.isEnded(taskService.find(ID_TASK_NOT_ENDED)));
	}
	
	@Test
	public void testTaskPrevisionalEndingDateIsInAnIntervalOfDates() {
		assertTrue(taskService.previsionalEndingDateIsInAnIntervalOfDates(taskService.find(ID_TASK_ENDING_IN_AN_INTERVAL_OF_DATES), BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE));
	}

	@Test
	public void testListNotEndedUserTasksInAnIntervalOfDates() {
		assertFalse(taskService.listNotEndedUserTasksInAnIntervalOfDates(ID_USER, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE).isEmpty());
	}
	
	@Test
	public void testEndAllTasksInList() {
		taskService.endAllTasksInList(taskService.listNotEndedUserTasksInAnIntervalOfDates(ID_USER_END_ALL_TASKS, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE));
		assertTrue(taskService.listNotEndedUserTasksInAnIntervalOfDates(ID_USER_END_ALL_TASKS, BEGINNING_INTERVAL_DATE, ENDING_INTERVAL_DATE).isEmpty());
	}
}
