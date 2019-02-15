package com.harmonyit.shoppinglist.authservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.harmonyit.shoppinglist.authservice.security.service.UserDetailsServiceImpl;

/**
 * The Class AuthServiceApplication.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAuthorizationServer
//@Import({HagueSwaggerConfiguration.class})
public class AuthServiceApplication {

  /** The LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceApplication.class);

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(final String[] args) {
	  LOGGER.info("Starting microservice AuthServiceApplication");
    SpringApplication.run(AuthServiceApplication.class, args);
  }

  /**
   * Provides a custom DB user details service.
   *
   * @return the custom user details service
   */
  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }
}
