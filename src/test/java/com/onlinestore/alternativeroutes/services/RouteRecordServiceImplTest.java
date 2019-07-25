package com.onlinestore.alternativeroutes.services;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import com.onlinestore.alternativeroutes.exceptions.RouteRecordNotFoundException;
import com.onlinestore.alternativeroutes.repositories.RouteRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RouteRecordServiceImplTest {
	private static final String SERVICE_NAME = "customerservice";

	private RouteRecordService routeRecordService;

	@Mock
	private RouteRecordRepository routeRecordRepository;

	@Spy
	RouteRecord routeRecord;

	@BeforeEach
	public void setUp() throws Exception {
		routeRecordService = new RouteRecordServiceImpl(routeRecordRepository);
	}

	@Test
	public void shouldGetRouteRecordByServiceId() throws Exception {
		when(routeRecordRepository.findByServiceName(SERVICE_NAME)).thenReturn(Optional.of(routeRecord));
		routeRecordService.getRouteRecordByServiceName(SERVICE_NAME);
		verify(routeRecordRepository).findByServiceName(SERVICE_NAME);
	}

	@Test
	public void shouldThrowExceptionWhenEmptyOptional() throws Exception {
		when(routeRecordRepository.findByServiceName(SERVICE_NAME)).thenReturn(Optional.empty());

		assertThrows(RouteRecordNotFoundException.class,
				() -> routeRecordService.getRouteRecordByServiceName(SERVICE_NAME));
	}
}