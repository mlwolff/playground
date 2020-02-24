package com.lupus.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/api/hello"
			)
	@ResponseBody
	public String helloWorld() {
		return "Hello, world.";
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			value = "/api/hellouser"
			)
	@ResponseBody
	public String helloUser(
				@RequestParam(name = "user", defaultValue = "world") String user 
			) {
		return "Hello, " + user;
	}
}
