package com.harmonyit.shoppinglist.authservice.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;

@Configuration("authServerSecurityConfiguration")
@Order(AuthServerSecurityConfiguration.LOW_PRIORITY)
public class AuthServerSecurityConfiguration extends AuthorizationServerSecurityConfiguration {
  // By default Spring security beans has order = 0
  /** The Constant LOW_PRIORITY. */
  static final int LOW_PRIORITY = -4;

  @Autowired
  UserDetailsService userDetailsService;

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  // Set dao userDetailsService to AuthenticationManagerBuilder, needed for password flow
  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.parentAuthenticationManager(authenticationManagerBean()).userDetailsService(userDetailsService);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
   * #configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
   */
  @Override
  public void configure(final WebSecurity web) throws Exception {
    // Ignore OPTIONS calls for basic authentication
    super.configure(web);
    web.ignoring().antMatchers(HttpMethod.OPTIONS);
  }

}
