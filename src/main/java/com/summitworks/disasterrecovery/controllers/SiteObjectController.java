package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
//@CrossOrigin(origin = "http://localhost:4200/")
@AllArgsConstructor
public class SiteObjectController {

	private final SiteObjectRepository siteObjectRepository;

	@GetMapping("/")
	@RolesAllowed("CONTRACTOR")
	public String getSiteObjects() {
		return siteObjectRepository.findAll().toString();
	}

}
