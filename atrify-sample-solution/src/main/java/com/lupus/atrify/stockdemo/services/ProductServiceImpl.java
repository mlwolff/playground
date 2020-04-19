package com.lupus.atrify.stockdemo.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lupus.atrify.stockdemo.jpa.Product;
import com.lupus.atrify.stockdemo.jpa.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository repository;
	
	@Override
	public Product add(Product product) {
		Objects.requireNonNull(product);
		Objects.requireNonNull(product.getArticleNumber());
		
		Optional<Product> byId = repository.findById(product.getArticleNumber());
		if (byId.isPresent()) {
			throw new RuntimeException(String.format("Product with articleNumber %s already exists.", product.getArticleNumber()));
		}
		
		return repository.save(product);
	}

	@Override
	public void remove(String articleNumber) {
		repository.deleteById(articleNumber);
	}

	@Override
	public Iterable<Product> getAll() {
		return repository.findAll();
	}

	@Override
	public Product getByArticleNumber(String articleNumber) {
		return repository.findById(articleNumber).orElse(null);
	}

	@Override
	public List<Product> getByName(String productName) {
		return repository.findByName(productName);
	}
	
	@Override
	public long getNumberOfProducts() {
		return repository.count();
	}

}
