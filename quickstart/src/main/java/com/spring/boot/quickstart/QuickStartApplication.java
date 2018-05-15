package com.spring.boot.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Stream;

@SpringBootApplication
public class QuickStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickStartApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(CustomerRepository cr) {
		return args -> Stream.of("Mary", "Jesus", "Devil", "God").forEach(s -> cr.save(new Customer(s)));
	}

}
