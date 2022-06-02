package com.summitworks.disasterrecovery.models.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "time_sheet_approvals")
@Getter
@Setter
@DiscriminatorOptions(force = true)
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheetObject {
	@Id
	private int id;
	private String contractorName;
	//@Max(25)
	private String siteCode;
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<ObjectData> siteObjects = new HashSet<>();
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

	public TimeSheetObject(String contractorName, String siteCode, Set<ObjectData> siteObjects) {
		this.id = new Random().nextInt();
		this.contractorName = contractorName;
		this.siteCode = siteCode;
		this.siteObjects = siteObjects;
	}

	public void addSiteObject(SiteObject siteObject, int hoursUsed) {
		addSiteObject(siteObject.getCode(), hoursUsed);
	}

	public void addSiteObject(String siteCode, int hoursUsed) {
		this.siteObjects.add(new ObjectData(siteCode, hoursUsed));
	}

}
