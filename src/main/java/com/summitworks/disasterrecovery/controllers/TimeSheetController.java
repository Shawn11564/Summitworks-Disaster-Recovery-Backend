package com.summitworks.disasterrecovery.controllers;


import com.summitworks.disasterrecovery.controllers.requests.TimesheetReq;
import com.summitworks.disasterrecovery.controllers.responses.MessageResponse;
import com.summitworks.disasterrecovery.models.objects.ObjectData;
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
	public void deleteSiteObject(@PathVariable("id") String sheetId) {
		timesheetService.deleteTimesheet(Integer.parseInt(sheetId));
	}
	
	@PostMapping("/create")
	@RolesAllowed({"CONTRACTOR", "ADMIN"})
	public ResponseEntity<?> createTimesheet(@Valid @RequestBody TimesheetReq timesheetrequest) {
		System.out.println(timesheetrequest.toString());
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

		timesheetService.saveTimesheet(timesheet);

		return ResponseEntity.ok(new MessageResponse("Timesheet created!"));
	}
}
