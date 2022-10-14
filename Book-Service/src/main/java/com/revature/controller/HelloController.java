package com.revature.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello from " + this.serverPort;
	}
}
