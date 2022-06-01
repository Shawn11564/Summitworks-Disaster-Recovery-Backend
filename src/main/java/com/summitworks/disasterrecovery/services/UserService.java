package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.users.User;
import com.summitworks.disasterrecovery.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
