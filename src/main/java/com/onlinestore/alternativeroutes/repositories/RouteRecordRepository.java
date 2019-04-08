package com.onlinestore.alternativeroutes.repositories;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data repository for {@link RouteRecord} class.
 */
@Repository
public interface RouteRecordRepository extends JpaRepository<RouteRecord, String> {
	/**
	 * Returns route record of the specified service from database.
	 *
	 * @param serviceName name of the service
	 * @return Optional of route record
	 */
	Optional<RouteRecord> findByServiceName(String serviceName);
}
