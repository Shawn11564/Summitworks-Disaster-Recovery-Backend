package com.summitworks.disasterrecovery.controllers;


import com.summitworks.disasterrecovery.controllers.requests.TimeSheetRequest;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import com.summitworks.disasterrecovery.repositories.TimeSheetRepository;
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
	private final TimeSheetRepository timesheetrepository;
	private final TimeSheetService timeSheetService;

	@GetMapping("/all")
	public List<TimeSheetObject> getTimeSheets() {
		return timeSheetService.getAll();
	}

	@GetMapping("/timesheet/{id}")
	public TimeSheetObject getTimesheet(@PathVariable("id") String sheetId) {
		return timeSheetService.getTimesheet(Long.parseLong(sheetId));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createSiteObject(@Valid @RequestBody TimeSheetRequest timesheetrequest) {
		
		TimeSheetObject TimeSheet = new TimeSheetObject(
				timesheetrequest.getId(), 
				timesheetrequest.getContractorName(),
				timesheetrequest.getSiteCode(),
				timesheetrequest.getTotalHours(), 
				timesheetrequest.getStatus() 
				);
		
//		TimeSheet.setSiteObjects(
//				new HashSet<>(List.of(
//				);
		
//		TimeSheetObject TimeSheet = new TimeSheetObjet(timesheetrequest.getCode,
//				timesheetrequest.getHourlyRate(), timesheetrequest.getMaxHoursPerDay(), timesheetrequest.)
//				
//			
//		
//		timeSheetService.saveTimeSheet(TimeSheet);
		timesheetrepository.save(TimeSheet);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
