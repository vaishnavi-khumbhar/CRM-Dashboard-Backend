package com.crm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailIgnoreCase(String email);
	}

