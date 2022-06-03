package com.summitworks.disasterrecovery.models.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "site_code_2")
@DiscriminatorOptions(force = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class SiteObject {

	@Id
	private String code;
	private int type;
	private String description;
	private double hourlyRate;
	private int maxHoursPerDay;

	@Override
	public String toString() {
		return "SiteObject{" +
				"code='" + code + '\'' +
				", type=" + type +
				", description='" + description + '\'' +
				", hourlyRate=" + hourlyRate +
				", maxHoursPerDay=" + maxHoursPerDay +
				'}';
	}
}
