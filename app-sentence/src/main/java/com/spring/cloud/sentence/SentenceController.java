package com.spring.cloud.sentence;

import com.spring.cloud.sentence.dao.GreetingService;
import com.spring.cloud.sentence.dao.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private GreetingService greetingService;
	@Autowired
	private PersonService personService;

	@GetMapping("/sentence")
	String getSentence() {
		String greetingFormat = greetingService.greeting();
		String person = personService.person();
		return String.format(greetingFormat, person);
	}

	//@GetMapping("/sentence")
	String getSentenceWithRestTemplate() {
		String greetingFormat = getWordWithRestTemplateAndRibbon("app-greeting");
		String person = getWordWithRestTemplateAndRibbon("app-person");
		return String.format(greetingFormat, person);

	}

	//@GetMapping("/sentence")
	String getSentenceWithServiceDiscovery() {
		String greetingFormat = getWordWithServiceDiscovery("app-greeting");
		String person = getWordWithServiceDiscovery("app-person");
		return String.format(greetingFormat, person);

	}

	private String getWordWithRestTemplateAndRibbon(String service) {
		//Using Ribbon with default configs which runs a round-robin algorithm and relies on eureka to obtain the list of
		//actual healthy servers. This can cause some requests since eureka takes some time to unregistered servers that stopped running

		return restTemplate.getForObject("http://" + service, String.class);
	}

	private String getWordWithServiceDiscovery(String service) {
		//Using service discovery to get a URI for a service manually (not the best approach, of course
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}
}