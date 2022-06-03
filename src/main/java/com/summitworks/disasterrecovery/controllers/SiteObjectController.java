package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.controllers.requests.SiteObjectRequest;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.models.objects.impl.Job;
import com.summitworks.disasterrecovery.models.objects.impl.Machine;
import com.summitworks.disasterrecovery.services.SiteObjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public SiteObject getSiteObject(@PathVariable("id") String objectId) {
		return siteObjectService.getSiteObject(objectId);
	}

	@DeleteMapping("/admin/delete/{id}")
	@RolesAllowed("ADMIN")
	public void deleteSiteObject(@PathVariable("id") String objectId) {
		System.out.println("Request received");
		siteObjectService.deleteSiteObject(objectId);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createSiteObject(@Valid @RequestBody SiteObjectRequest siteObjectRequest) {
		if (siteObjectService.existsByCode(siteObjectRequest.getCode())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Object code is already taken!"));
		}

		SiteObject siteObject;

		if (siteObjectRequest.getType().equalsIgnoreCase("job")) {
			siteObject = new Job(
					siteObjectRequest.getCode(),
					1,
					siteObjectRequest.getDescription(),
					Double.parseDouble(siteObjectRequest.getHourlyRate()),
					Integer.parseInt(siteObjectRequest.getMaxHoursPerDay())
			);
		} else {
			siteObject = new Machine(
					siteObjectRequest.getCode(),
					2,
					siteObjectRequest.getDescription(),
					Double.parseDouble(siteObjectRequest.getHourlyRate()),
					Integer.parseInt(siteObjectRequest.getMaxHoursPerDay())
			);
		}
		siteObjectService.saveSiteObject(siteObject);

		return ResponseEntity.ok(new MessageResponse("Site object saved!"));
	}

}
