package com.harmonyit.assessments.gamehouse.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The Class ItemServiceApplication.
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.harmonyit.assessments.gamehouse.api")
@SpringBootApplication
public class ItemServiceApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

}
