package com.accenture.banking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =WebEnvironment.DEFINED_PORT)
public class TestApplicationBuilder {
	
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void testOfficeById() throws Exception {

		String response = restTemplate.getForObject("http://localhost:8082/offices/1", String.class);
		
		assertThat(response, containsString("678678678"));		
	}	    
	  	
	@Test
	public void contextLoads() {
	}
}
