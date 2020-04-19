package com.lupus.atrify.stockdemo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("products-api")
				.apiInfo(apiInfo()).select().paths(productPaths()).build();
	}

	private Predicate<String> productPaths() {
		return or(regex("/shop/products.*"), regex("/shop/products/.*"));
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Michael Wolff", "https://www.atrify.com", "mwolff@atrify.com");
		
		return new ApiInfoBuilder().title("Shop Demo API")
				.description("Demo Shop API solution for appicants")
				.termsOfServiceUrl("http://atrify.com")
				.contact(contact).license("(c) 2020 by atrify GmbH")
				.licenseUrl("mwolff@atrify.com").version("1.0").build();
	}

}
