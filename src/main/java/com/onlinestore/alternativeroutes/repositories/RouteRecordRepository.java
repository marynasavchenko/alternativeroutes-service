package com.onlinestore.alternativeroutes.repositories;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for {@link RouteRecord} class.
 */
@Repository
public interface RouteRecordRepository extends JpaRepository<RouteRecord, String> {
	/**
	 * Looks up route record of the specified service in the database.
	 *
	 * @param serviceName name of the service
	 * @return route record
	 */
	RouteRecord findByServiceName(String serviceName);
}
