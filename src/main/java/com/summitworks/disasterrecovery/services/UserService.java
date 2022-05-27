package com.summitworks.disasterrecovery.services;

//import com.summitworks.disasterrecovery.repositories.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class UserService implements UserDetailsService {
//
//	private final UserRepository userRepository;
//	private final PasswordEncoder encoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		final Optional<User> optionalUser = userRepository.findByEmail(email);
//
//		if (optionalUser.isPresent()) {
//			return optionalUser.get();
//		} else {
//			throw new UsernameNotFoundException(
//					String.format("User with email %s cannot be found.", email)
//			);
//		}
//	}
//
//	/*
//	 *  Register a new user to the system
//	 */
//	public void registerUser(User user) {
//		// encrypt original password
//		final String encryptedPassword = encoder.encode(user.getPassword());
//
//		// set password to encrypted version
//		user.setPassword(encryptedPassword);
//
//		// save user to database
//		userRepository.save(user);
//	}
//
//}
