package com.spring.cloud.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${greetings}")
	private String greetings;

	@GetMapping("/")
	public String getWord() {
		String[] greetingArray = greetings.split(",");
		int i = (int)Math.round(Math.random() * (greetingArray.length - 1));
		return greetingArray[i];
	}
}
