package com.paypal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paypal.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByUserEmail(String userEmail);
}
