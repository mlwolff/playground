package com.lupus.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lupus.springboot.api.Status;

@RestController
public class StatusController {
	
	@GetMapping(name = "status", path = "/api/status")
	public Status status() {
		return new Status();
	}
}
