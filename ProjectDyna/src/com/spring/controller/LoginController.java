package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bean.User;
import com.spring.service.LoginService;

@Controller
@RequestMapping(value="/loginRest")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<User> isUserValid(@RequestParam String inputEmailAddress, @RequestParam String inputPassword) {
		// Call the DB to check if the user login details are correct or not.
		System.out.println("In Login Controller");
		return new ResponseEntity<User>(loginService.getUser(inputEmailAddress), HttpStatus.OK);
	}
}
