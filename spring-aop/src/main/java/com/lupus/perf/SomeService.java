package com.lupus.perf;

import org.springframework.stereotype.Component;

import com.lupus.aop.PerfTracker;

@Component
public class SomeService {
	@PerfTracker
	public void process() {
		System.out.println("Processing " + this.getClass().getSimpleName());
	}
}
