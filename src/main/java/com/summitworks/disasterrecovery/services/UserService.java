package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.users.Roles;
import com.summitworks.disasterrecovery.models.users.User;
import com.summitworks.disasterrecovery.repositories.RoleRepository;
import com.summitworks.disasterrecovery.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	public void makeAdmin(long id) {
		User user = userRepository.getReferenceById(id);

		user.setRoles(
				new HashSet<>(List.of(
						roleRepository.findByName(Roles.CONTRACTOR).get(),
						roleRepository.findByName(Roles.ADMIN).get()
				))
		);
		userRepository.save(user);
	}

}
