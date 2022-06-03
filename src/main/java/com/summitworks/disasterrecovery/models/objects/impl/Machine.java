package com.summitworks.disasterrecovery.models.objects.impl;

import com.summitworks.disasterrecovery.models.objects.SiteObject;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Machine extends SiteObject {

	public Machine(String code, int type, String description, double hourlyRate, int maxHoursPerDay) {
		super(code, type, description, hourlyRate, maxHoursPerDay);
	}
}
