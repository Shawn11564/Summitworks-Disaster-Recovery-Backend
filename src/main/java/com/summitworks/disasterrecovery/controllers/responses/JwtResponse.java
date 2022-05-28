package com.summitworks.disasterrecovery.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {

	private String token;
	private final String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;



}
