package com.lupus.atrify.stockdemo.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Methods accessing and manipulating {@link Product} data.
 *  
 * @author mlwolff
 *
 */
public interface ProductRepository extends CrudRepository<Product, String> {

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Product> findByName(String name);
	
}
