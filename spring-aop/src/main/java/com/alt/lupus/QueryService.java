/**
 * 
 */
package com.alt.lupus;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.lupus.aop.PerfTracker;
import com.lupus.perf.SomeService;

/**
 * @author mwolff
 *
 */
@Configurable(autowire = Autowire.BY_TYPE)
public class QueryService {
	@Autowired
	public SomeService sSvc;
	
	public QueryService() {
		System.out.println("Constructor called.");
	}
	
	@PerfTracker(trackerId = "executeRandom")
	public void execute() {
		int randomWaitTime = (int) (Math.random()*2000);
		
		try {
			System.out.print("Wait " + randomWaitTime + " millis... ");
			TimeUnit.MILLISECONDS.sleep(randomWaitTime);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("done.");
			System.out.flush();
		}
		
		if (sSvc != null) {
			sSvc.process();
		} else {
			System.err.println("SomeService not wired.");
		}
	}

	@PerfTracker(trackerId = "executeSpecified")
	public void execute(long millis) {
		
		try {
			System.out.print("Wait " + millis + " millis... ");
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("done.");
			System.out.flush();
		}
		
		if (sSvc != null) {
			sSvc.process();
		} else {
			System.err.println("SomeService not wired.");
		}
	}
}
