package com.spring.cloud.sentence.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("app-person")
public interface PersonService {

	@GetMapping("/")
	String person();
}
