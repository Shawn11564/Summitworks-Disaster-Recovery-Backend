package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.controllers.requests.LoginRequest;
import com.summitworks.disasterrecovery.controllers.requests.RegisterRequest;
import com.summitworks.disasterrecovery.controllers.responses.JwtResponse;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.models.users.Roles;
import com.summitworks.disasterrecovery.models.users.User;
import com.summitworks.disasterrecovery.repositories.RoleRepository;
import com.summitworks.disasterrecovery.repositories.UserRepository;
import com.summitworks.disasterrecovery.security.jwt.JwtUtils;
import com.summitworks.disasterrecovery.security.users.WebUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder encoder;
	private final JwtUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		WebUserDetails userDetails = (WebUserDetails) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities()
										.stream()
										.map(GrantedAuthority::getAuthority)
										.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(
				jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles
		));
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Email is already taken!"));
		}

		// create new account
		User user = new User(
				registerRequest.getUsername(),
				registerRequest.getEmail(),
				encoder.encode(registerRequest.getPassword())
		);
		user.setRoles(
				new HashSet<>(List.of(
						roleRepository.findByName(Roles.CONTRACTOR).get()
				))
		);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
