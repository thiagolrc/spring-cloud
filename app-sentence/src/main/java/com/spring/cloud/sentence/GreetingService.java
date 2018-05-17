package com.spring.cloud.sentence;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("app-greeting")
public interface GreetingService {

	@GetMapping("/")
	String greeting();
}
