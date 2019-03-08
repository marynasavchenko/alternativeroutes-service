package com.onlinestore.alternativeroutes.services;

import com.onlinestore.alternativeroutes.model.RouteRecord;
import com.onlinestore.alternativeroutes.repositories.RouteRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteRecordService {

	private RouteRecordRepository routeRecordRepository;

	@Autowired
	public RouteRecordService(RouteRecordRepository routeRecordRepository) {
		this.routeRecordRepository = routeRecordRepository;
	}

	public RouteRecord getRouteRecordByServiceName(String serviceName) {
		return routeRecordRepository.findByServiceName(serviceName);
	}
}
