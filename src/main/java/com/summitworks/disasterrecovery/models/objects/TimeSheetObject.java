package com.summitworks.disasterrecovery.models.objects;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Time_Sheet_Approvals")
@Getter
@Setter
@DiscriminatorOptions(force = true)
public class TimeSheetObject {
	@Id
	private int id;
	private String contractorName;
	private String siteCode;
	private int totalHours;
	private String status;

	@Override
	public String toString() {
		return "TimeSheetObject{" +
				"id=" + id +
				", contractorName='" + contractorName + '\'' +
				", siteCode='" + siteCode + '\'' +
				", totalHours=" + totalHours +
				", status='" + status + '\'' +
				'}';
	}
}
