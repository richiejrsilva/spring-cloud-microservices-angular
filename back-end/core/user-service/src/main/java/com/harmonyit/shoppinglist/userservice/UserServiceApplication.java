package com.harmonyit.shoppinglist.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The Class UserServiceApplication.
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.harmonyit.shoppinglist.api")
@SpringBootApplication
public class UserServiceApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
