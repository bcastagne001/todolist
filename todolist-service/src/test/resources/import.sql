-- TaskServiceTest
-- testlistThreeLastTasks
-- ID_ACCOUNT_TYPE = 1L
INSERT INTO TA_ACCOUNT_TYPE(label) VALUES('FREE');
-- ID_USER = 1L
INSERT INTO user(name, USER_TYPE) VALUES('testNameUser', 'USER_FREE')
-- ID_CATEGORY = 1L
INSERT INTO category(name) VALUES('testNameCategory')
-- ID_TASK = 1L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask1DB', 1);
-- ID_TASK = 2L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask2DB', 1);
-- ID_TASK = 3L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask3DB', 1);
-- testAddTaskWithLessThanTenTasksForFreeUser
-- ID_USER = 2L
INSERT INTO user(name, USER_TYPE) VALUES('AddTaskWithLessThanTenTasksForFreeUser', 'USER_FREE')
-- testEndedTaskIsEnded
-- ID_TASK = 4L
INSERT INTO task(label, endingDate, id_user) VALUES('testFind3lastTask4DB', '2016-11-17 09:36:15', 1);
-- testNotEndedTaskIsNotEnded
-- ID_TASK = 5L
INSERT INTO task(label, beginningDate, id_user) VALUES('testFind3lastTask5DB', '2016-11-15 09:36:15', 1);
-- testTaskExpectedEndingDateIsInAnIntervalOfDates
-- ID_TASK = 6L
INSERT INTO task(label, previsionalEndingDate, id_user) VALUES('testFind3lastTask6DB', '2016-11-20 09:36:15', 1);
-- testAddTaskWithLessThanTenTasksForFreeUser
-- ID_USER = 3L
INSERT INTO user(name, USER_TYPE) VALUES('ListNotEndedUserTasksInAnIntervalOfDates', 'USER_FREE')
-- ID_TASK = 7L
INSERT INTO task(label, previsionalEndingDate, id_user) VALUES('testFind3lastTask7DB', '2016-11-22 09:36:15', 3);