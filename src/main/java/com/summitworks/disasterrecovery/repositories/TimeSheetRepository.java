package com.summitworks.disasterrecovery.repositories;

import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheetObject, Integer> {

	@Query(value = "SELECT * from time_sheet_approvals", nativeQuery = true)
	List<TimeSheetObject> getAllTimeSheetObjects();

}
