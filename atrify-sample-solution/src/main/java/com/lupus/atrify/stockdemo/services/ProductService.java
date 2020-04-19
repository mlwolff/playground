/**
 * 
 */
package com.lupus.atrify.stockdemo.services;

import java.util.List;

import com.lupus.atrify.stockdemo.jpa.Product;

/**
 * Service for registering/deregistering {@link Product Products}.
 * 
 * @author mwolff
 *
 */
public interface ProductService {
	/**
	 * 
	 * @param product
	 */
	Product add(Product product);
	
	/**
	 * 
	 * @param articleNumber
	 * @return true, if a product could be removed, otherwise false.
	 */
	boolean remove(String articleNumber);
	
	/**
	 * 
	 * @return
	 */
	Iterable<Product> getAll();
	
	/**
	 * 
	 * @param articleNumber
	 * @return
	 */
	Product getByArticleNumber(String articleNumber);
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	List<Product> getByName(String productName);
	
	/**
	 * 
	 * @return
	 */
	long getNumberOfProducts();
	
}
