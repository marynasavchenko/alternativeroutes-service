package com.onlinestore.alternativeroutes.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RouteRecordJpaTest {
	private static final String SERVICE_NAME = "customerservice";
	private static final String ACTIVE_STATUS = "YES";
	private static final String ENDPOINT = "";
	private static final int WEIGHT = 1;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void shouldMapRouteRecordEntity() throws Exception {
		RouteRecord routeRecord = new RouteRecord(SERVICE_NAME, ACTIVE_STATUS, ENDPOINT, WEIGHT);
		RouteRecord foundRouteRecord = this.entityManager.persistAndFlush(routeRecord);
		Assertions.assertThat(foundRouteRecord.getServiceName()).isEqualTo(SERVICE_NAME);
	}
}