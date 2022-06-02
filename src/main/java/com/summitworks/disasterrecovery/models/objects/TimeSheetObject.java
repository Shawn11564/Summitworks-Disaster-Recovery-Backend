package com.summitworks.disasterrecovery.models.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;

import com.summitworks.disasterrecovery.models.users.Role;

import javax.persistence.*;
import javax.validation.constraints.Max;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@Max(25)
	private String siteCode;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<SiteObject> siteObjects = new HashSet<>();
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
	public TimeSheetObject (int id, String contractorName, String sitdeCode, int totalHours, String status){
		this.id = id;
		this.contractorName = contractorName;
		this.siteCode = siteCode;
		this.totalHours = totalHours;
		this.status = status;
	}
}
