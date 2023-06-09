package com.paypal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.enums.TaskPriority;
import com.paypal.enums.TaskStatus;
import com.paypal.model.Sprint;
import com.paypal.model.Task;
import com.paypal.repository.TaskRepository;
import com.paypal.service.TaskService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins= "*")
public class TaskController {
	
	@Autowired
    private TaskService taskService;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	@PostMapping("/createTask")
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		
		return new ResponseEntity<Task>(taskService.createTask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateTask/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable Long taskId,@RequestBody Task task){
		
		return new ResponseEntity<Task>(taskService.updateTask(taskId,task), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getAllTasks")
	public ResponseEntity<List<Task>> getAllTask(){
		
		List<Task> getAllTask = taskRepository.findAll();
		
		return new ResponseEntity<List<Task>>(getAllTask, HttpStatus.OK);
	}
	
	@GetMapping("/getTask/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId) {
		
		Task task= taskService.getTaskById(taskId);
		return task;
    }
	
	@GetMapping("/sprint/{id}")
    public ResponseEntity<List<Task>> getTasksBySprint(@PathVariable("id") Long sprintId) {
        
        return new ResponseEntity<>(taskService.getTasksBySprint(sprintId), HttpStatus.OK);
    }
	
	@GetMapping("/sprintAssignee/{id}")
	public ResponseEntity<List<Task>> getTasksByAssignee(@PathVariable String assignee){
		
		return new ResponseEntity<>(taskService.getTasksByAssignee(assignee), HttpStatus.OK);
	}
	
	@PostMapping("/AssignTask/{taskId}/{assignee}")
	public ResponseEntity<?> assignTask(@PathVariable Long taskId,@PathVariable String assignee){
		
		taskService.assignTask(taskId, assignee);
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteTask/{taskId}")
	public ResponseEntity<?> deleteTask(@PathVariable Long taskId){
		
		taskService.deleteTask(taskId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/filterByPriority/{priority}")
	public ResponseEntity<List<Task>> filterByTaskPriority(@PathVariable TaskPriority priority){
		
		return new ResponseEntity<List<Task>>(taskRepository.findByPriority(priority), HttpStatus.OK);
	}
	
	@GetMapping("/filterByStatus/{status}")
	public ResponseEntity<List<Task>> filterByTasStatus(@PathVariable TaskStatus status){
		
		return new ResponseEntity<List<Task>>(taskRepository.findByStatus(status), HttpStatus.OK);
	}
	
	
	

}
