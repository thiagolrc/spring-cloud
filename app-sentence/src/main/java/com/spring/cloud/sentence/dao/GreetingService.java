package com.spring.cloud.sentence.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ATTENTION
 * There is a limitation with the implementation of fallbacks in Feign and how Hystrix fallbacks work.
 * Fallbacks are currently not supported for methods that return com.netflix.hystrix.HystrixCommand and rx.Observable
 */
@FeignClient(name = "app-greeting", fallback = GreetingService.GreetingServiceFallback.class)
public interface GreetingService {

	@GetMapping("/")
	String greeting();

	@Component
	public static class GreetingServiceFallback  implements GreetingService {
		@Override
		public String greeting() {
			return "Hi %s, we're facing some problems with our system. We'll be back soon";
		}
	}
}
