package com.lupus.atrify.stockdemo.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product {

	/** The unique article number of a product. */
	@Id
	@ApiModelProperty(value="The unique article number of a product", required = true)
	private String articleNumber;
	
	/** Some name. */
	@ApiModelProperty("The product's name")
	private String name;

	protected Product() {}; // Required by JPA.
	
	public Product(String articleNumber, String name) {
		super();
		this.articleNumber = articleNumber;
		this.name = name;
	}

	/**
	 * 
	 * @return The unique article numner of the product.
	 */
	public String getArticleNumber() {
		return articleNumber;
	}

	/**
	 * Sets the article number for the product.
	 * 
	 * @param articleNumber
	 * 		The article number.
	 */
	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	/**
	 * 
	 * @return The name of the product.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the product.
	 * 
	 * @param name
	 * 		The product name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [articleNumber=" + articleNumber + ", name=" + name + "]";
	}
	
	
}
