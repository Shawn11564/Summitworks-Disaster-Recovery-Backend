package com.summitworks.disasterrecovery.repositories;

import com.summitworks.disasterrecovery.models.objects.SiteObject;
import com.summitworks.disasterrecovery.models.objects.impl.Job;
import com.summitworks.disasterrecovery.models.objects.impl.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteObjectRepository extends JpaRepository<SiteObject, String> {

	@Query(value = "SELECT * from Site_code where type = 1", nativeQuery = true)
	List<Job> getAllJobs();

	@Query(value = "SELECT * from Site_code where type = 2", nativeQuery = true)
	List<Machine> getAllMachines();

	List<SiteObject> findAllByCode(String code);

}
