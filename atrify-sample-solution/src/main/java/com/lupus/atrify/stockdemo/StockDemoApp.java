package com.lupus.atrify.stockdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lupus.atrify.stockdemo.jpa.Product;
import com.lupus.atrify.stockdemo.services.ProductService;

@SpringBootApplication
public class StockDemoApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(StockDemoApp.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StockDemoApp.class, args);
	}

	@Bean
	public CommandLineRunner setupRepositories(ProductService svc) {
		return (args) -> {
			svc.add(new Product("4711", "Kölnisch Wasser"));
			svc.add(new Product("0815", "Schrott"));
			svc.add(new Product("0000", "Noch mehr Schrott"));
			
			LOGGER.info(String.format("%d products registered", svc.getNumberOfProducts()));			

			for (Product product : svc.getAll()) {
				LOGGER.info(String.valueOf(product));
			}
			
		};
	}

}
