package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.models.objects.impl.Job;
import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteObjectService {

	private final SiteObjectRepository siteObjectRepository;

	@Autowired
	public SiteObjectService(SiteObjectRepository siteObjectRepository) {
		this.siteObjectRepository = siteObjectRepository;
		Job test = new Job();
		test.setCode("testjob");
		test.setType(1);
		test.setDescription("this is the latest data");
		test.setHourlyRate(12);
		test.setMaxHoursPerDay(9);
		saveSiteObject(test);
	}

	public void saveSiteObject(SiteObject siteObject) {
		siteObjectRepository.save(siteObject);
	}

}
