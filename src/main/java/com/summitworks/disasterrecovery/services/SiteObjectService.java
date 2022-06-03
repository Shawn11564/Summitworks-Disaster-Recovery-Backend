package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.repositories.SiteObjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SiteObjectService {

	private final SiteObjectRepository siteObjectRepository;

	public List<SiteObject> getAll() {
		return siteObjectRepository.findAll();
	}

	public List<SiteObject> getAllBySiteCode(String siteCode) {
		return siteObjectRepository.findAllByCode(siteCode);
	}

	public SiteObject getSiteObject(String id) {
		return siteObjectRepository.findByCode(id);
	}

	public void saveSiteObject(SiteObject siteObject) {
		siteObjectRepository.save(siteObject);
	}

	public void deleteSiteObject(String id) {
		siteObjectRepository.deleteById(id);
	}

	public boolean existsByCode(String code) {
		return siteObjectRepository.existsById(code);
	}

}
