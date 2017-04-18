package com.diallab.rest;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContatoControllerTest {
	
	@Test
	public void getAll() {
		
		String uri = "http://localhost:8080/listatelefonica/all";
		Response response = RestAssured.get(uri);
		
		Assert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
		
	}

}
