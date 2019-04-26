package com.onlinestore.alternativeroutes.services;

import com.onlinestore.alternativeroutes.exceptions.RouteRecordNotFoundException;
import com.onlinestore.alternativeroutes.domain.RouteRecord;
import com.onlinestore.alternativeroutes.repositories.RouteRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link RouteRecordService} interface.
 */
@Service
public class RouteRecordServiceImpl implements RouteRecordService {
	/**
	 * Spring Data repository for {@link RouteRecord}.
	 */
	private RouteRecordRepository routeRecordRepository;

	/**
	 * Constructs new {@code RouteRecordService} instance.
	 *
	 * @param routeRecordRepository Spring Data repository
	 */
	@Autowired
	public RouteRecordServiceImpl(RouteRecordRepository routeRecordRepository) {
		this.routeRecordRepository = routeRecordRepository;
	}

	/**
	 * Gets route record of the specified service.
	 *
	 * @param serviceName name of the service
	 * @return route record
	 * @throws RouteRecordNotFoundException if {@code routeRecordRepository} returns empty Optional
	 */
	public RouteRecord getRouteRecordByServiceName(String serviceName) {
		return routeRecordRepository.findByServiceName(serviceName)
				.orElseThrow(() -> new RouteRecordNotFoundException(serviceName));
	}

	@Override
	public void addAddRouteRecord(RouteRecord routeRecord) {
		routeRecordRepository.save(routeRecord);
	}
}
