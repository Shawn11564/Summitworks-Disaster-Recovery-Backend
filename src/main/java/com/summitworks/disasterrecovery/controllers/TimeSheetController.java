package com.summitworks.disasterrecovery.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
public class TimeSheetController {

	//@GetMapping("/")
	@RolesAllowed("CONTRACTOR")
	public String getSiteObjects() {
		return "";
	}
	
}
