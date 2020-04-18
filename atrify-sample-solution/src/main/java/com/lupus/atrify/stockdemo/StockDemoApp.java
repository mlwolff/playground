package com.lupus.atrify.stockdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lupus.atrify.stockdemo.jpa.Product;
import com.lupus.atrify.stockdemo.jpa.ProductRepository;

@SpringBootApplication
public class StockDemoApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(StockDemoApp.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StockDemoApp.class, args);
	}

	@Bean
	public CommandLineRunner setupRepositories(ProductRepository repo) {
		return (args) -> {
			repo.save(new Product("4711", "Kölnisch Wasser"));
			repo.save(new Product("0815", "Schrott"));
			
			LOGGER.info(String.format("Stored %d products", repo.count()));			
			
			repo.save(new Product("0815", "Schrott"));

		};
	}

}
