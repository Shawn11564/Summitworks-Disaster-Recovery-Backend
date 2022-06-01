package com.summitworks.disasterrecovery.controllers.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SiteObjectRequest {

	@NotBlank
	private String code;
	@NotBlank
	private int type;
	@NotBlank
	private String description;
	@NotBlank
	private double hourlyRate;
	@NotBlank
	private int maxHoursPerDay;

}
