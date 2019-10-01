package com.ravindra;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ravindra.model.Address;
import com.ravindra.model.Provider;

public class ProviderRestControllerTest extends ApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	private BeanTester beanTester;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/*
	 * private Provider providerDetails() { Provider provider = new Provider();
	 * provider.setProviderId(""); return provider; }
	 */

	@Test
	public void testCreateProvider() throws Exception {
		String requestJson = "{\r\n" + "	\"providerId\":\"P987\",\r\n" + "	\"providerName\":\"Junit\",\r\n"
				+ "	\"providerType\":\"G\",\r\n" + "	\"ssn\":\"987654321\",\r\n" + "	\"serviceLocations\":[\r\n"
				+ "		{\r\n" + "			\"addressType\":\"service\",\r\n"
				+ "			\"street\":\"pragathinagar\",\r\n" + "			\"state\":\"TS\",\r\n"
				+ "			\"zipCode\":\"500090\",\r\n" + "			\"country\":\"IN\"\r\n" + "		},\r\n"
				+ "		{\r\n" + "			\"addressType\":\"billing\",\r\n"
				+ "			\"street\":\"NNPAalli\",\r\n" + "			\"state\":\"AP\",\r\n"
				+ "			\"zipCode\":\"523305\",\r\n" + "			\"country\":\"IN\"\r\n" + "		}\r\n"
				+ "		]\r\n" + "}";
		beanTester.testBean(Provider.class);
		beanTester.testBean(Address.class);
		mockMvc.perform(post("/provider").contentType("application/json;charset=UTF-8").content(requestJson))
				.andExpect(status().isOk()).andReturn();
	}

	/**
	 * mockMvc.perform(get("/empservices/getemp")).andExpect(status().isOk())
	 * .andExpect(content().contentType("application/json;charset=UTF-
	 * 8")).andExpect(jsonPath("$.empId").value("123"))
	 * .andExpect(jsonPath("$.empName").value("Ravi")).andExpect(jsonPath("$.emp
	 * Sal").value("10000")); }
	 */
	@After
	public void tearDown() {

	}
}