package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/object")
@AllArgsConstructor
public class SiteObjectController {

	private final SiteObjectRepository siteObjectRepository;

	@GetMapping("/all")
	@RolesAllowed("CONTRACTOR")
	public String getSiteObjects() {
		return siteObjectRepository.findAll().toString();
	}

}
