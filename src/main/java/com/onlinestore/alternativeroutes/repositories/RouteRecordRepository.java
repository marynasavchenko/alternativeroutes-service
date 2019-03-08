package com.onlinestore.alternativeroutes.repositories;

import com.onlinestore.alternativeroutes.model.RouteRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRecordRepository extends JpaRepository<RouteRecord, String> {

	RouteRecord findByServiceName(String serviceName);
}
