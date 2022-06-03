package com.summitworks.disasterrecovery.controllers.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TimesheetReq {

	@NotBlank
	//@Max(25)
	private String siteCode;
	@NotBlank
	private String contractor;
	@NotBlank
	private String date;
	@NotBlank
	private String jobOneCode;
	private int jobOneHours;
	@NotBlank
	private String jobTwoCode;
	private int jobTwoHours;
	@NotBlank
	private String jobThreeCode;
	private int jobThreeHours;
	@NotBlank
	private String machineOneCode;
	private int machineOneHours;
	@NotBlank
	private String machineTwoCode;
	private int machineTwoHours;
	@NotBlank
	private String machineThreeCode;
	private int machineThreeHours;

	@Override
	public String toString() {
		return "TimesheetReq{" +
				"siteCode='" + siteCode + '\'' +
				", contractor='" + contractor + '\'' +
				", date='" + date + '\'' +
				", jobOneCode='" + jobOneCode + '\'' +
				", jobOneHours=" + jobOneHours +
				", jobTwoCode='" + jobTwoCode + '\'' +
				", jobTwoHours=" + jobTwoHours +
				", jobThreeCode='" + jobThreeCode + '\'' +
				", jobThreeHours=" + jobThreeHours +
				", machineOneCode='" + machineOneCode + '\'' +
				", machineOneHours=" + machineOneHours +
				", machineTwoCode='" + machineTwoCode + '\'' +
				", machineTwoHours=" + machineTwoHours +
				", machineThreeCode='" + machineThreeCode + '\'' +
				", machineThreeHours=" + machineThreeHours +
				'}';
	}
}
