package com.spring.cloud.person;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Value("${persons}")
	private String persons;

	@GetMapping("/")
	public String getWord() {
		String[] personArray = persons.split("#");
		int i = (int)Math.round(Math.random() * (personArray.length - 1));
		return personArray[i];
	}
}
