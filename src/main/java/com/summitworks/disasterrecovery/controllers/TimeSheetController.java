package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import com.summitworks.disasterrecovery.services.TimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/timesheet")
@RolesAllowed({"CONTRACTOR", "ADMIN"})
@AllArgsConstructor
public class TimeSheetController {

	private final TimeSheetService timeSheetService;

	@GetMapping("/all")
	public List<TimeSheetObject> getTimeSheets() {
		return timeSheetService.getAll();
	}

	@GetMapping("/timesheet/{id}")
	public TimeSheetObject getTimesheet(@PathVariable("id") String sheetId) {
		return timeSheetService.getTimesheet(Long.parseLong(sheetId));
	}
}
