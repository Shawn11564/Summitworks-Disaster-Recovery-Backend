package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SiteObjectController {

	private final SiteObjectRepository siteObjectRepository;

	@GetMapping("/")
	public String getSiteObjects() {
		return siteObjectRepository.findAll().toString();
	}

}
