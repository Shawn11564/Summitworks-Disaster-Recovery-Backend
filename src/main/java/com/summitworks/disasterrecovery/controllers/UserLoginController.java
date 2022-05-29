package com.summitworks.disasterrecovery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.disasterrecovery.repositories.UserService;

@RestController
@Slf4j
@Validated
public class UserLoginController {
	UserService authentication;
	//private final UserService userService;

//	@GetMapping("/login")
//	public void login() {
//		
//		// TODO: open login page
//	}
//	@PostMapping("/login")
//	public void login(@RequestBody @Valid ) {
//		
//		// TODO: open login page
//	}
	@PostMapping("/login")
	  String login(
	    @RequestParam("username") final String username,
	    @RequestParam("password") final String password) {
	    return authentication
	      .login(username, password)
	      .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	 }
	
	@GetMapping("/logout")
	public void logout() {
		// TODO: logout
	}

}
