package com.spring.boot.configClient.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

	@Value("${hello-world}")
	private String helloWorld;

	@GetMapping("/hello-world")
	String helloWorld() {
		return helloWorld;
	}
}
