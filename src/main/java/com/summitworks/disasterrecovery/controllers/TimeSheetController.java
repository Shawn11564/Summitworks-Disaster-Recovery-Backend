package com.summitworks.disasterrecovery.controllers;

<<<<<<< Updated upstream
import lombok.AllArgsConstructor;
=======
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
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
//@CrossOrigin(origin = "http://localhost:4200/")
@AllArgsConstructor
public class TimeSheetController {

	//@GetMapping("/")
	@RolesAllowed("CONTRACTOR")
	public String getSiteObjects() {
		return "";
	}
	
<<<<<<< Updated upstream
=======
	@PostMapping("/")
	public ResponseEntity<?> inserttimesheet(@Valid @RequestBody LoginRequest loginRequest){
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

>>>>>>> Stashed changes
}
