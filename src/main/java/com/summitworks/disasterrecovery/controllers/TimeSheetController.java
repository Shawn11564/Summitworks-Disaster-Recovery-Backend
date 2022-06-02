package com.summitworks.disasterrecovery.controllers;


import com.summitworks.disasterrecovery.controllers.requests.TimeSheetRequest;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import com.summitworks.disasterrecovery.services.SiteObjectService;
import com.summitworks.disasterrecovery.services.TimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/timesheet")
@RolesAllowed({"CONTRACTOR", "ADMIN"})
@AllArgsConstructor
public class TimeSheetController {
	private final TimeSheetService timesheetService;
	private final SiteObjectService siteObjectService;

	@GetMapping("/all")
	public List<TimeSheetObject> getTimeSheets() {
		return timesheetService.getAll();
	}

	@GetMapping("/timesheet/{id}")
	public TimeSheetObject getTimesheet(@PathVariable("id") String sheetId) {
		return timesheetService.getTimesheet(Integer.parseInt(sheetId));
	}

	@PostMapping("/timesheet/{id}/add/{siteObjectId}")
	public ResponseEntity<?> addSiteObject(@PathVariable("id") String sheetId, @PathVariable("siteObjectId") String siteObjectId) {
		if (!timesheetService.existsByCode(Integer.parseInt(sheetId))) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Timesheet does not exist!"));
		}
		if (!siteObjectService.existsByCode(siteObjectId)) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Site object does not exist!"));
		}

		TimeSheetObject timesheet = timesheetService.getTimesheet(Integer.parseInt(sheetId));
		timesheet.addSiteObject(siteObjectService.getSiteObject(siteObjectId));

		timesheetService.saveTimesheet(timesheet);

		return ResponseEntity.ok(new MessageResponse("Added site object to timesheet!"));
	}

	@DeleteMapping("/delete/{id}")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public void deleteSiteObject(@PathVariable("id") String sheetId) {
		timesheetService.deleteTimesheet(Integer.parseInt(sheetId));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createTimesheet(@Valid @RequestBody TimeSheetRequest timesheetrequest) {
		if (timesheetService.existsByCode(timesheetrequest.getId())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Timesheet id is already taken!"));
		}

		TimeSheetObject timesheet = new TimeSheetObject(
				timesheetrequest.getId(), 
				timesheetrequest.getContractorName(),
				timesheetrequest.getSiteCode(),
				timesheetrequest.getTotalHours(), 
				timesheetrequest.getStatus() 
		);

		timesheet.setSiteObjects(
				new HashSet<>(siteObjectService.getAllBySiteCode(timesheetrequest.getSiteCode()))
		);

		timesheetService.saveTimesheet(timesheet);

		return ResponseEntity.ok(new MessageResponse("Timesheet created!"));
	}
}
