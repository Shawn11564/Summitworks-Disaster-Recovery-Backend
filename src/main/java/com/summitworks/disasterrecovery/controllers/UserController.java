package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/login")
	void login() {
		// TODO: open login page
	}

}
