package com.summitworks.disasterrecovery.controllers;


import lombok.AllArgsConstructor;

import com.summitworks.disasterrecovery.controllers.requests.LoginRequest;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.services.TimeSheetService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;


import com.summitworks.disasterrecovery.controllers.requests.TimesheetReq;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.models.objects.ObjectData;
import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import com.summitworks.disasterrecovery.repositories.ObjectDataRepository;
import com.summitworks.disasterrecovery.services.SiteObjectService;
import com.summitworks.disasterrecovery.services.TimeSheetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/timesheet")
@AllArgsConstructor
public class TimeSheetController {
	private final TimeSheetService timesheetService;
	private final SiteObjectService siteObjectService;
	private final ObjectDataRepository objectDataRepository;

	@GetMapping("/admin/all")
	@RolesAllowed("ADMIN")
	public List<TimeSheetObject> getTimeSheets() {
		return timesheetService.getAll();
	}

	@GetMapping("/admin/data/all")
	@RolesAllowed("ADMIN")
	public List<ObjectData> getAllObjectData() {
		return objectDataRepository.findAll();
	}

	@GetMapping("/timesheet/{id}")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public TimeSheetObject getTimesheet(@PathVariable("id") String sheetId) {
		return timesheetService.getTimesheet(Integer.parseInt(sheetId));
	}

	@GetMapping("/timesheet/{id}/cost")
	@RolesAllowed("ADMIN")
	public double getTimesheetCost(@PathVariable("id") String sheetId) {
		TimeSheetObject timesheet = timesheetService.getTimesheet(Integer.parseInt(sheetId));
		double totalCost = 0.0;
		for (ObjectData objectData : timesheet.getSiteObject()) {
			SiteObject siteObject = siteObjectService.getSiteObject(objectData.getCode());

			totalCost += siteObject.getHourlyRate() * objectData.getHoursWorked();
		}

		return totalCost;
	}

	@PostMapping("/timesheet/{id}/add/{siteObjectId}")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
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
		timesheet.addSiteObject(siteObjectService.getSiteObject(siteObjectId), 0);

		timesheetService.saveTimesheet(timesheet);

		return ResponseEntity.ok(new MessageResponse("Added site object to timesheet!"));
	}

	@DeleteMapping("/admin/delete/{id}")
	@RolesAllowed("ADMIN")
	public void deleteTimesheet(@PathVariable("id") String sheetId) {
		timesheetService.deleteTimesheet(Integer.parseInt(sheetId));
	}

	@PutMapping("/admin/approve/{id}")
	@RolesAllowed("ADMIN")
	public void approveTimesheet(@PathVariable("id") String timesheetId) {
		timesheetService.approveTimesheet(Integer.parseInt(timesheetId));
	}
	

	@PostMapping("/")
	public ResponseEntity<?> inserttimesheet(@Valid @RequestBody LoginRequest loginRequest){
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}


	@PostMapping("/create")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public ResponseEntity<?> createTimesheet(@Valid @RequestBody TimesheetReq timesheetrequest) {
		Set<ObjectData> objectData = new HashSet<>(List.of(
				new ObjectData(timesheetrequest.getJobOneCode(), timesheetrequest.getJobOneHours()),
				new ObjectData(timesheetrequest.getJobTwoCode(), timesheetrequest.getJobTwoHours()),
				new ObjectData(timesheetrequest.getJobThreeCode(), timesheetrequest.getJobThreeHours()),
				new ObjectData(timesheetrequest.getMachineOneCode(), timesheetrequest.getMachineOneHours()),
				new ObjectData(timesheetrequest.getMachineTwoCode(), timesheetrequest.getMachineTwoHours()),
				new ObjectData(timesheetrequest.getMachineThreeCode(), timesheetrequest.getMachineThreeHours())
		));

		for (ObjectData data : objectData) {
			if (!objectDataRepository.existsById(data.getId())) {
				objectDataRepository.save(data);
			}
		}

		TimeSheetObject timesheet = new TimeSheetObject(
				timesheetrequest.getContractor(),
				timesheetrequest.getSiteCode(),
				objectData
		);

		timesheet.setStatus("Pending");

		timesheetService.saveTimesheet(timesheet);

		return ResponseEntity.ok(new MessageResponse("Timesheet created!"));
	}

}
