package com.summitworks.disasterrecovery.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TimeSheetController {

	@GetMapping("/")
	@RolesAllowed("CONTRACTOR")
	public String getSiteObjects() {
		return "";
	}
	
}
