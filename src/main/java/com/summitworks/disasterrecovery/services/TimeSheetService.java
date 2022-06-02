package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import com.summitworks.disasterrecovery.repositories.TimeSheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TimeSheetService {

	private final TimeSheetRepository timeSheetRepository;

	public List<TimeSheetObject> getAll() {
		return timeSheetRepository.getAllTimeSheetObjects();
	}

	public TimeSheetObject getTimesheet(int id) {
		return timeSheetRepository.getReferenceById(id);
	}
	
	public void saveTimesheet(TimeSheetObject timeSheet) {
		timeSheetRepository.save(timeSheet);
	}

	public void deleteTimesheet(int id) {
		timeSheetRepository.deleteById(id);
	}

	public boolean existsByCode(int code) {
		return timeSheetRepository.existsById(code);
	}

}
