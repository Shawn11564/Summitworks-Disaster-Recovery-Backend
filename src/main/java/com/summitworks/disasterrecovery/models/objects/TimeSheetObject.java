package com.summitworks.disasterrecovery.models.objects;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorOptions;

import com.summitworks.disasterrecovery.models.users.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "Time_Sheet_Approvals")
@Getter
@Setter
@DiscriminatorOptions(force = true)
public class TimeSheetObject {
	@Id
	int Id;
	String Contractor_name;
	String Site_code;
	int Total_hours;
	String Status;
	
	@Override
	public String toString() {
		return "SiteObject{" +
				"Id='" + Id + '\'' +
				", Contractor_name=" + Contractor_name +
				", Site_code='" + Site_code + '\'' +
				", Status=" + Status +
				'}';
	}
	
}
