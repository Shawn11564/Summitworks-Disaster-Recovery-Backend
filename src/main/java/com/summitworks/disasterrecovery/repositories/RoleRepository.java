package com.summitworks.disasterrecovery.repositories;

import com.summitworks.disasterrecovery.models.users.Role;
import com.summitworks.disasterrecovery.models.users.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(Roles name);

}
