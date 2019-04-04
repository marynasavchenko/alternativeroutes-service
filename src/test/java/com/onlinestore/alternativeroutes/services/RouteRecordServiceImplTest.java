package com.onlinestore.alternativeroutes.services;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import com.onlinestore.alternativeroutes.repositories.RouteRecordRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RouteRecordServiceImplTest {
	private static final String SERVICE_NAME = "customerservice";

	private RouteRecordService routeRecordService;

	@Mock
	private RouteRecordRepository routeRecordRepository;

	@Spy
	RouteRecord routeRecord;

	@Before
	public void setUp() throws Exception {
		routeRecordService = new RouteRecordServiceImpl(routeRecordRepository);
	}

	@Test
	public void shouldGetRouteRecordByServiceId() throws Exception {
		when(routeRecordRepository.findByServiceName(SERVICE_NAME)).thenReturn(Optional.of(routeRecord));
		routeRecordService.getRouteRecordByServiceName(SERVICE_NAME);
		verify(routeRecordRepository).findByServiceName(SERVICE_NAME);
	}
}