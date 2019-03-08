package com.onlinestore.alternativeroutes.controllers;

import com.onlinestore.alternativeroutes.model.RouteRecord;
import com.onlinestore.alternativeroutes.services.RouteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/route")
public class AlternativeRoutesServiceController {

	private RouteRecordService routeRecordService;

	@Autowired
	public AlternativeRoutesServiceController(RouteRecordService routeRecordService) {
		this.routeRecordService = routeRecordService;
	}

	@GetMapping(value = "/records/{serviceName}")
	public RouteRecord getRouteRecord(@PathVariable("serviceName") String serviceName) {
		return routeRecordService.getRouteRecordByServiceName(serviceName);
	}

}
