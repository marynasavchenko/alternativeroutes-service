package com.onlinestore.alternativeroutes.repositories;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RouteRecordRepositoryTest {
	private static final String SERVICE_NAME = "customerservice";

	@Autowired
	private RouteRecordRepository routeRecordRepository;

	private RouteRecord routeRecord;

	@BeforeEach
	public void setUp() throws Exception {
		routeRecord = new RouteRecord(SERVICE_NAME, "YES", "", 3);
	}

	@AfterEach
	public void tearDown() throws Exception {
		routeRecordRepository.deleteAll();
	}

	@Test
	public void shouldReturnRouteRecord() throws Exception {
		routeRecordRepository.save(routeRecord);
		Optional<RouteRecord> optionalRoutRecord = routeRecordRepository.findByServiceName(SERVICE_NAME);
		assertEquals(routeRecord, optionalRoutRecord.get());
	}

	@Test
	public void shouldReturnEmptyOptionalWhenNoRecord() throws Exception {
		Optional<RouteRecord> optionalRoutRecord = routeRecordRepository.findByServiceName(SERVICE_NAME);
		assertEquals(Optional.empty(), optionalRoutRecord);
	}
}