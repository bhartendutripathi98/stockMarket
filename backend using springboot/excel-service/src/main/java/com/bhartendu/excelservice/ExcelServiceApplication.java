package com.bhartendu.excelservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class ExcelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bhartendu"))
				.build();
				//.apiInfo(apiDetails());
	}
	
//	private ApiInfo apiDetails() {
//		return new ApiInfo(
//				"Excel Microservice API",
//				"API Documentation for Excel Microservice",
//				"1.0",
//				"Copyright- Roushan Raj",
//				new springfox.documentation.service.Contact("Roushan Raj", "https://roushanraj.github.io/", "roushan.nsit@gmail.com"),
//				"API License",
//				"https://github.com/roushanraj/Stock-Market-Application", Collections.emptyList());
//	}

}
