package com.summitworks.disasterrecovery.services;

import com.summitworks.disasterrecovery.repositories.TimeSheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TimeSheetService {

	private final TimeSheetRepository timeSheetRepository;



}
