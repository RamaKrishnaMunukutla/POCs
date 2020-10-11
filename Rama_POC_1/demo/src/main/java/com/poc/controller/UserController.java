package com.poc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.model.User;
import com.poc.response.ErrorResponse;
import com.poc.response.SuccessResponse;
import com.poc.service.UserService;
import com.poc.utility.BusinessException;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	ErrorResponse errorResponse = new ErrorResponse();

	Logger logger = Logger.getLogger(this.getClass());

	@PostMapping(value = "/createUser", produces = { "application/json", "application/xml" })
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		logger.debug("incoming request for createUser UserController ::::" + user);
		try {
		if (user != null && user.getUserName() != null && !user.getUserName().isEmpty()) {
			SuccessResponse createUser = userService.createUser(user);
			logger.debug("response for createUser UserController ::::" + createUser);
			return new ResponseEntity<Object>(createUser, HttpStatus.OK);
		} else {
			logger.debug("incoming request for createUser UserController ::::" + "request is invalid");
			errorResponse.setStatusCode("422");
			errorResponse.setStatusMessage("Request Object is invalid");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		}
		catch(BusinessException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		

	}
}
