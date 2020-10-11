package com.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.model.User;


public interface UserDao extends JpaRepository<User, Long> {
	
}
