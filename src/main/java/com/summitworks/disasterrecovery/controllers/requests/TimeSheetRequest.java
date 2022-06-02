package com.summitworks.disasterrecovery.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class TimeSheetRequest {

	@Id
	@NotBlank
	private int id;
	@NotBlank
	private String contractorName;
	@Max(25)
	@NotBlank
	private String siteCode;
	@NotBlank
	private int totalHours;
	@NotBlank
	private String status;

}
