package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteObjectService {

	private final SiteObjectRepository siteObjectRepository;

	@Autowired
	public SiteObjectService(SiteObjectRepository siteObjectRepository) {
		this.siteObjectRepository = siteObjectRepository;
	}

	public void saveSiteObject(SiteObject siteObject) {
		siteObjectRepository.save(siteObject);
	}

}
