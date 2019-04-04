package com.onlinestore.alternativeroutes.controllers;

import com.onlinestore.alternativeroutes.services.RouteRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AlternativeRoutesServiceController.class, secure = false)
public class AlternativeRoutesServiceControllerTest {

	private static final String SERVICE_NAME = "customerservice";
	private static final String URI = "/v1/route/records/customerservice";

	@MockBean
	private RouteRecordService routeRecordService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void shouldGetRouteRecordByServiceName() throws Exception {
		mockMvc.perform(get(URI)).andExpect((status().isOk()));
		verify(routeRecordService).getRouteRecordByServiceName(SERVICE_NAME);
	}
}