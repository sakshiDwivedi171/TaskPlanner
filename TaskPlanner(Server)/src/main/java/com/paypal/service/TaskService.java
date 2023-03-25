package com.paypal.service;

import java.util.List;

import com.paypal.exceptions.TaskException;
import com.paypal.model.Task;

public interface TaskService {
	
	public Task getTaskById(Long taskId) throws TaskException;
	
    public List<Task> getTasksBySprint(Long sprintId) throws TaskException;
    
    public List<Task> getTasksByAssignee(String assignee) throws TaskException;
    
    public Task createTask(Task task) throws TaskException;
    
    public Task updateTask(Long taskId, Task task) throws TaskException;
    
    public void assignTask(Long taskId, String assignee) throws TaskException;
    
    public void deleteTask(Long taskId) throws TaskException;
    

}
