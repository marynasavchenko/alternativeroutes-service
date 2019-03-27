package com.onlinestore.alternativeroutes.controllers;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import com.onlinestore.alternativeroutes.services.RouteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for managing route's records.
 */
@RestController
@RequestMapping(value = "/v1/route")
public class AlternativeRoutesServiceController {
	/**
	 * Service that supports opertions with route records.
	 */
	private RouteRecordService routeRecordService;

	/**
	 * Constructs a new {@code AlternativeRoutesServiceController} instance.
	 *
	 * @param routeRecordService
	 */
	@Autowired
	public AlternativeRoutesServiceController(RouteRecordService routeRecordService) {
		this.routeRecordService = routeRecordService;
	}

	/**
	 * GET  /records/{serviceName} : gets route record of specified service.
	 *
	 * @param serviceName name of the service
	 * @return route record
	 */
	@GetMapping(value = "/records/{serviceName}")
	public RouteRecord getRouteRecord(@PathVariable("serviceName") String serviceName) {
		return routeRecordService.getRouteRecordByServiceName(serviceName);
	}

}
