/**
 * 
 */
package com.lupus.atrify.stockdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lupus.atrify.stockdemo.jpa.Product;
import com.lupus.atrify.stockdemo.services.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author mwolff
 *
 */

@RestController
@RequestMapping("/shop/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	
	/**
	 * @return All products.
	 */
	@ApiOperation("Returns a list of all available products")
	@GetMapping()
	@ResponseBody
	public Iterable<Product> list() {
		Iterable<Product> all = productService.getAll();
		
		return all;
	}
	

	/**
	 * Adds or updates a product.
	 * @param articleNumber
	 * 		The article number.
	 * @param product
	 * 		The product.
	 * @return
	 * 		The saved product
	 */
	@ApiOperation("Adds or updates a new, resp. an existing product")
	@PutMapping(value = "/{articleNumber}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE})
	
	@ResponseBody
	public Product add(
			@ApiParam("The articlenumber of the product")
			@PathVariable String articleNumber,
			
			@ApiParam("The product to add. Note: Article number will be taken from path parameter {articleNumber}.")
			@RequestBody Product product) {
		
		// Don't care about the articlenumber in product POJO.
		product.setArticleNumber(articleNumber);
		
		return productService.add(product);
		
	}
	
	@ApiOperation("Gets the product for the specified articlenumber")
	@GetMapping(value = "/{articleNumber}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Product get(
			@ApiParam("The articlenumber of the product")
			@PathVariable String articleNumber) {
		Product product = productService.getByArticleNumber(articleNumber);
		
		if (product != null) {
			return product;
		}
		
		throw new NotFoundException("No product found with article number: " + articleNumber);
	}
	
	@ApiOperation("Removes the product with the specified articlenumber")
	@DeleteMapping(value = "/{articleNumber}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(
			@ApiParam("The articlenumber of the product")
			@PathVariable String articleNumber) {
		
		if (!productService.remove(articleNumber)) {
			throw new NotFoundException("No product exists with article number: " + articleNumber);
		}
	}
}
