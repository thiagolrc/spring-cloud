package com.spring.boot.quickstart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CustomerRepository cr;

	@Test
	public void whenGettingCustomers_thenShoulListAllCustomers() throws Exception {
		//given
		Customer c1 = new Customer("c1");
		Customer c2 = new Customer("c2");
		when(cr.findAll()).thenReturn(Arrays.asList(c1, c2));

		//when
		ResultActions actions = mockMvc
				.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON));


		//then
		actions.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("c1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("c2"));

	}
}