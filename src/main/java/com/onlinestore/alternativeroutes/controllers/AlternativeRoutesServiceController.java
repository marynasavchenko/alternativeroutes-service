package com.onlinestore.alternativeroutes.controllers;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import com.onlinestore.alternativeroutes.services.RouteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for managing route's records.
 */
@RestController
@RequestMapping(value = "/v1/route")
public class AlternativeRoutesServiceController {
	/**
	 * Service that supports operations with route records.
	 */
	private RouteRecordService routeRecordService;

	/**
	 * Constructs new {@code AlternativeRoutesServiceController} instance.
	 *
	 * @param routeRecordService
	 */
	@Autowired
	public AlternativeRoutesServiceController(RouteRecordService routeRecordService) {
		this.routeRecordService = routeRecordService;
	}

	/**
	 * GET  /records/{serviceName} : gets route record of the specified service.
	 *
	 * @param serviceName name of the service
	 * @return route record
	 */
	@GetMapping(value = "/records/{serviceName}")
	public RouteRecord getRouteRecord(@PathVariable("serviceName") String serviceName) {
		return routeRecordService.getRouteRecordByServiceName(serviceName);
	}

	@PostMapping(value = "/records")
	@ResponseStatus(HttpStatus.CREATED)
	public void addRouteRecord(RouteRecord routeRecord) {
		routeRecordService.addAddRouteRecord(routeRecord);
	}

}
