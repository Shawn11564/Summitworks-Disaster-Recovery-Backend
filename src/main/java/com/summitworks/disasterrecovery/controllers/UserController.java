package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.models.users.User;
import com.summitworks.disasterrecovery.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/admin")
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/all")
	@RolesAllowed("ADMIN")
	public List<User> getUsers() {
		return userService.getAll();
	}

	@DeleteMapping("/delete/{id}")
	@RolesAllowed("ADMIN")
	public void deleteUser(@PathVariable("id") String userId) {
		userService.deleteUser(Long.parseLong(userId));
	}

	@PutMapping("/makeadmin/{id}")
	@RolesAllowed("ADMIN")
	public void makeAdmin(@PathVariable("id") String userId) {
		userService.makeAdmin(Long.parseLong(userId));
	}

}
