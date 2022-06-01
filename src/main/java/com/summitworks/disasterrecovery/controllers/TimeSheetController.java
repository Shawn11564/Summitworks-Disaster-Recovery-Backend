package com.summitworks.disasterrecovery.controllers;

import com.summitworks.disasterrecovery.services.TimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/timesheet")
@AllArgsConstructor
public class TimeSheetController {

	private final TimeSheetService timeSheetService;

	@GetMapping("/all")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public String getTimeSheets() {
		return timeSheetService.getAll().toString();
	}

}
