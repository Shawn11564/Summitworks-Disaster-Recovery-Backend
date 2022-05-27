package com.summitworks.disasterrecovery.models.objects;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public abstract class SiteObject {

	@Id
	private String code;
	private SiteObjectType type;
	private String description;
	private double hourlyRate;
	private double maxHoursPerDay;

}
