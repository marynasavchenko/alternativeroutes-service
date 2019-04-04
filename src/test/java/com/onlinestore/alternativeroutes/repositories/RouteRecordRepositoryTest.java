package com.onlinestore.alternativeroutes.repositories;

import com.onlinestore.alternativeroutes.domain.RouteRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RouteRecordRepositoryTest {
	private static final String SERVICE_NAME = "customerservice";

	@Autowired
	private RouteRecordRepository routeRecordRepository;

	private RouteRecord routeRecord;

	@Before
	public void setUp() throws Exception {
		routeRecord = new RouteRecord(SERVICE_NAME, "YES", "", 3);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void shouldReturnRouteRecord() throws Exception {
		routeRecordRepository.save(routeRecord);
		Optional<RouteRecord> optionalRoutRecord = routeRecordRepository.findByServiceName(SERVICE_NAME);
		assertEquals(routeRecord, optionalRoutRecord.get());
	}
}