package com.spring.boot.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
class CustomerController {

	@Autowired
	private CustomerRepository cr;

	@GetMapping("/customers")
	Collection<Customer> findAll() {
		return cr.findAll();
	}

}
