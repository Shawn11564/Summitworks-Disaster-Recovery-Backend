package com.summitworks.disasterrecovery.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

	@NotBlank
	private String username;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String password;
	private Set<String> roles;



}
