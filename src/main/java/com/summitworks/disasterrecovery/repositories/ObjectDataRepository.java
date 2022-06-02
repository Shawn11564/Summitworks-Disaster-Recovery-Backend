package com.summitworks.disasterrecovery.repositories;

import com.summitworks.disasterrecovery.models.objects.ObjectData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectDataRepository extends JpaRepository<ObjectData, Integer> { }
