package com.tsfn.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.beans.Task;
import com.tsfn.services.TaskService;

//@Controller
//@ResponseBody
@RestController // =Controller + responseBody
public class TaskControler {
	@Autowired
	TaskService taskService;

	@GetMapping(value = "/tasks/getall")
	public Iterable<Task> getAllTasks() {
		return taskService.getTasks();
	}

}