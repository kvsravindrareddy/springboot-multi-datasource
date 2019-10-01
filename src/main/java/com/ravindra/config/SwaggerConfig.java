package com.ravindra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiInfo() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any()).build().apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("API End Points").description("\"Online Training\"").version("1.0.0")
				.license("Trending Technologies").licenseUrl("www.trendingtechnologies.in")
				.contact(new Contact("Ravindra Kakarla", "www.trendingtechnologies.in", "info@trendingtechnologies.in"))
				.build();
	}
}