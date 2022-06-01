package com.summitworks.disasterrecovery.models.objects;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import javax.validation.constraints.Max;

import java.util.List;

@Entity
@Table(name = "time_sheet_approvals")
@Getter
@Setter
@DiscriminatorOptions(force = true)
public class TimeSheetObject {
	@Id
	private int id;
	private String contractorName;
	@Max(16)
	private String siteCode;
	@OneToMany(fetch = FetchType.LAZY)
	private List<SiteObject> siteObjects;
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
