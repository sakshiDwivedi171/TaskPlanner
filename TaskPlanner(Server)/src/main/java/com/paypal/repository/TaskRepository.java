package com.paypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findBySprintId(Long sprintId);
    List<Task> findByAssignee(String assignee);

}
