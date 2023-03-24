package com.paypal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.exceptions.TaskException;
import com.paypal.model.Task;
import com.paypal.repository.SprintRepository;
import com.paypal.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public Task getTaskById(Long taskId) throws TaskException{
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if(taskOptional.isEmpty()) {
        	throw null;
        }
        Task task = taskOptional.get();
        return task;
    }

    @Override
    public List<Task> getTasksBySprint(Long sprintId) throws TaskException{
        return taskRepository.findBySprintId(sprintId);
    }

    @Override
    public List<Task> getTasksByAssignee(String assignee) throws TaskException{
        return taskRepository.findByAssignee(assignee);
    }

    @Override
    public Task createTask(Task task) throws TaskException{
        
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task task) throws TaskException{
        Task existingTask = getTaskById(taskId);
        existingTask.setType(task.getType());
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setPriority(task.getPriority());
        existingTask.setEstimatedTime(task.getEstimatedTime());
        existingTask.setActualTime(task.getActualTime());
        existingTask.setDueDate(task.getDueDate());
        return taskRepository.save(existingTask);
    }

    @Override
    public void assignTask(Long taskId, String assignee) throws TaskException{
        Task task = getTaskById(taskId);
        task.setAssignee(assignee);
        taskRepository.save(task);
    }

	@Override
	public void deleteTask(Long taskId) throws TaskException {
		
		taskRepository.findById(taskId).orElseThrow(()-> new TaskException("Item not find with thid id"+taskId));
        if(taskId !=null) {
        taskRepository.deleteById(taskId);
        }
		
	}

	
}
