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
	private String type;
	@NotBlank
	private String description;
	@NotBlank
	private String hourlyRate;
	@NotBlank
	private String maxHoursPerDay;

	@Override
	public String toString() {
		return "SiteObjectRequest{" +
				"code='" + code + '\'' +
				", type='" + type + '\'' +
				", description='" + description + '\'' +
				", hourlyRate=" + hourlyRate +
				", maxHoursPerDay=" + maxHoursPerDay +
				'}';
	}
}
