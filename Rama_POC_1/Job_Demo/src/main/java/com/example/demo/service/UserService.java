package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.UserInfo;
import com.example.demo.repositary.UserRepo;

@Component
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
 

	public UserInfo getUser(@PathVariable("id") Integer id) {
		
		return userRepo.getOne(id);
	}

	public UserInfo save(@Valid @RequestBody UserInfo user) {
		 
		return userRepo.save(user);
	}

}
