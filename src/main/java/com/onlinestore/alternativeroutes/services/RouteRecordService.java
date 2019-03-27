package com.onlinestore.alternativeroutes.services;


import com.onlinestore.alternativeroutes.domain.RouteRecord;

/**
 * {@link RouteRecordService} defines an interface that supports operations for managing route records.
 */
public interface RouteRecordService {
	RouteRecord getRouteRecordByServiceName(String serviceName);
}
