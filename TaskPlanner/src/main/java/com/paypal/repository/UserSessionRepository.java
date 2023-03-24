package com.paypal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.model.CurrentUserSession;

public interface UserSessionRepository extends JpaRepository<CurrentUserSession, Long>{

	public String deleteByUuid(String uuId);
	
	public CurrentUserSession findByUuid(String uuId);
}
