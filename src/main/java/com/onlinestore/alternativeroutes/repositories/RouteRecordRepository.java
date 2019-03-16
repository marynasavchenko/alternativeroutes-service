package com.onlinestore.alternativeroutes.repositories;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRecordRepository extends JpaRepository<RouteRecord, String> {

	RouteRecord findByServiceName(String serviceName);
}
