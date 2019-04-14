package com.lupus.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alt.lupus.QueryService;
import com.lupus.perf.SomeService;

public class AopApp {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", AopApp.class);
		
//		SomeService service = ctx.getBean(SomeService.class);
//		service.process();
		
		QueryService queryService = new QueryService();
		
		queryService.execute();
		queryService.execute(2000);
	}

}
