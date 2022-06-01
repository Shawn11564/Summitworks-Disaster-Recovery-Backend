package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.controllers.requests.SiteObjectRequest;
import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.services.SiteObjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/objects")
@AllArgsConstructor
public class SiteObjectController {

	private final SiteObjectService siteObjectService;

	@GetMapping("/all")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public List<SiteObject> getSiteObjects() {
		return siteObjectService.getAll();
	}

	@GetMapping("/object/{id}")
	public SiteObject getSiteObject(@PathVariable("id") String objectId) {
		return siteObjectService.getSiteObject(objectId);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createSiteObject(@Valid @RequestBody SiteObjectRequest siteObjectRequest) {
		return null;
	}

}
