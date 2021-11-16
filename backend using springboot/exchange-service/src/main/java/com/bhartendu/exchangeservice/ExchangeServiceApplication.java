package com.bhartendu.exchangeservice;

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
public class ExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeServiceApplication.class, args);
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
//				"Stock Exchange Microservice API",
//				"API Documentation for Stock Exchange Microservice",
//				"1.0",
//				"Copyright- Roushan Raj",
//				new springfox.documentation.service.Contact("Roushan Raj", "https://roushanraj.github.io/", "roushan.nsit@gmail.com"),
//				"API License",
//				"https://github.com/roushanraj/Stock-Market-Application", Collections.emptyList());
//	}

}
