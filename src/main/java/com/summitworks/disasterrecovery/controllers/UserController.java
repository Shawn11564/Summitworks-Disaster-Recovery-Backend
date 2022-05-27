package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/login")
	public void login() {
		// TODO: open login page
	}

	@GetMapping("/logout")
	public void logout() {
		// TODO: logout
	}

}
