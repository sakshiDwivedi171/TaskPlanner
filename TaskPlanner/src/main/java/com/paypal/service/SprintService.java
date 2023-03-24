package com.paypal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.exceptions.SprintException;
import com.paypal.model.Sprint;
import com.paypal.repository.SprintRepository;

@Service
public class SprintService {
	
	@Autowired
    private SprintRepository sprintRepository;
    
    public Sprint createSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }
    
    public Sprint updateSprint(Long sprintId, Sprint sprint) {
    	
    	Sprint existingSprint = sprintRepository.findById(sprintId).orElse(null);
    	
    	if(existingSprint!=null) {
    		existingSprint.setTitle(sprint.getTitle());
    		existingSprint.setStartDate(sprint.getStartDate());
    		existingSprint.setEndDate(sprint.getEndDate());
    		return sprintRepository.save(existingSprint);
    	}
    	
		return null;
    	
    }
    
    public String deleteSprint(Long sprintId) throws SprintException{
    	
    	if(sprintId!=null) {
    		sprintRepository.deleteById(sprintId);
    	}
    	return "Deleted";
    }

}
