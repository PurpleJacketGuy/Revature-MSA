package com.revature.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigureRestTemplate {
	
	@Bean
	public RestTemplate restTemplateGenerator(RestTemplateBuilder builder) {
		return builder.build();
	}

}
