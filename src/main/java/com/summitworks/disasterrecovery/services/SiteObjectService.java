package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SiteObjectService {

	private final SiteObjectRepository siteObjectRepository;

	public void saveSiteObject(SiteObject siteObject) {
		siteObjectRepository.save(siteObject);
	}

}
