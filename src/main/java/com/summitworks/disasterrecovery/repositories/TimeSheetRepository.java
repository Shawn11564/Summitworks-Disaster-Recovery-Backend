package com.summitworks.disasterrecovery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.summitworks.disasterrecovery.models.objects.TimeSheetObject;
import com.summitworks.disasterrecovery.models.users.User;

public interface TimeSheetRepository extends JpaRepository<TimeSheetObject, Long> {
	@Query(value = "SELECT * from Time_Sheet_Approvals", nativeQuery = true)
	List<TimeSheetObject> getAllTimeSheetObjects();
}
