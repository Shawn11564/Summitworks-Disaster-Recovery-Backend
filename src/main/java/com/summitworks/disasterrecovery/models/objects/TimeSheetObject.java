package com.summitworks.disasterrecovery.models.objects;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.List;

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
