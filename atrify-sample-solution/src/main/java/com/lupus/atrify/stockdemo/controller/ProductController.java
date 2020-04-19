/**
 * 
 */
package com.lupus.atrify.stockdemo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	@ApiOperation("Returns a list of all available products")
	@GetMapping()
	@ResponseBody
	public Iterable<Product> list() {
		Iterable<Product> all = productService.getAll();
		
		return all;
	}
	

	@ApiOperation("Adds/registers a new product")
	@PutMapping(value = "/{articleNumber}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
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
	
	
}
