package com.spring.cloud.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties
class HelloWorldController {

	private String helloWorld;

	@GetMapping("/hello-world")
	String helloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}
}
