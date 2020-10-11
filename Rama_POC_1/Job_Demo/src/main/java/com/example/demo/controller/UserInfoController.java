package com.example.demo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserInfo;
import com.example.demo.repositary.UserRepo;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	UserRepo userRepo;

	private static final Logger log = LogManager.getLogger(UserInfoController.class);

	@PostMapping("/createuser")
	public UserInfo createUser(@Valid @RequestBody UserInfo userInfo) {
		log.debug(" ---Into the createUser Method--- ");
		return userRepo.save(userInfo);

	}

}
