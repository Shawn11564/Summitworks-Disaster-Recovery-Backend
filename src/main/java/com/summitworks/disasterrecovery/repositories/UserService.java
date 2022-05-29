package com.summitworks.disasterrecovery.repositories;


import java.util.Optional;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.summitworks.disasterrecovery.models.users.User;


//import net.bst.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService  {

	Optional<String> login(String username, String password);

	Optional<User> findByToken(String token);
	
	void logout(User user);
}