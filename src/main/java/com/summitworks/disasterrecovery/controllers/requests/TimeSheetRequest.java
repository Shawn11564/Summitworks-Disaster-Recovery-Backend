package com.summitworks.disasterrecovery.controllers.requests;

import com.summitworks.disasterrecovery.controllers.requests.timesheets.SiteObjectDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class TimeSheetRequest {

	@NotBlank
	private String code;
	@NotBlank
	private String contractor;
	@NotBlank
	private String date;
	@NotBlank
	private SiteObjectDetails jobs;
	@NotBlank
	private SiteObjectDetails machines;

}
