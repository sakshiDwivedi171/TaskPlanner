package com.paypal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.paypal.model.Sprint;
import com.paypal.repository.TaskRepository;
import com.paypal.service.SprintService;

@RestController
@RequestMapping("/Sprint")
@CrossOrigin(origins= "*")
public class SprintController {
	
	@Autowired
    private SprintService sprintService;
	
	
	@PostMapping("/createSprint")
    public ResponseEntity<Sprint> createSprint(@RequestBody Sprint sprint){
		
		return new ResponseEntity<>(sprintService.createSprint(sprint), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSprint")
	public ResponseEntity<Sprint> updateSprint(@PathVariable Long sprintId,@PathVariable Sprint sprint){
		
		return new ResponseEntity<>(sprintService.updateSprint(sprintId, sprint), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteSprint")
	public ResponseEntity<String> deleteSprint(@PathVariable Long sprintId){
		
		return new ResponseEntity<>(sprintService.deleteSprint(sprintId), HttpStatus.ACCEPTED);
	}
	

}
