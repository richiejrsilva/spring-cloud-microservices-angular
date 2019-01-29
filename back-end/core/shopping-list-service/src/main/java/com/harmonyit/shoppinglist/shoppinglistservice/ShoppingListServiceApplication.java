package com.harmonyit.shoppinglist.shoppinglistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The Class ShoppingListServiceApplication.
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.harmonyit.shoppinglist.api")
@SpringBootApplication
public class ShoppingListServiceApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ShoppingListServiceApplication.class, args);
	}

}
