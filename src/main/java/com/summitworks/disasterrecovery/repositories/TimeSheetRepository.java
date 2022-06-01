package com.summitworks.disasterrecovery.repositories;

import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheetObject, Long> {
	@Query(value = "SELECT * from Time_Sheet_Approvals", nativeQuery = true)
	List<TimeSheetObject> getAllTimeSheetObjects();

	@Query(value = "SELECT * from Time_Sheet_Approvals WHERE contractor_name = ?1", nativeQuery = true)
	List<TimeSheetObject> getContractorTimeSheetObjects(String name);

}
