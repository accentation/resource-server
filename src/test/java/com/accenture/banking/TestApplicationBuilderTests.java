package com.accenture.banking;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TestApplicationBuilderTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void testOfficeById() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/offices/1", String.class);

		assertThat(response, containsString("678678678"));
	}

	@Test
	public void testAccountById() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/offices/1/accounts/1", String.class);

		assertThat(response, containsString("calle Alcala 208 Madrid Spain"));
	}

	@Test
	public void testAccounts() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/offices/1/accounts/", String.class);

		assertThat(response, containsString("calle Alcala 208 Madrid Spain"));
	}

	@Test
	public void testClientById() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/clients/1", String.class);

		assertThat(response, containsString("Zinedine"));
	}

	@Test
	public void testClients() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/clients/", String.class);

		assertThat(response, containsString("Ladrón Gonzalez"));
	}


	@Test
	public void testClientsByClientId() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/clients/3/accounts", String.class);

		assertThat(response, containsString("ES91 2100 0418 0987 1205 1167"));
	}

	@Test
	public void contextLoads() {
	}
}
