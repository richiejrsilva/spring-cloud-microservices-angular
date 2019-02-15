package com.harmonyit.shoppinglist.authservice.oauth2.config.impl;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.harmonyit.shoppinglist.authservice.oauth2.config.TokenConfiguration;
import com.harmonyit.shoppinglist.authservice.security.service.oauth2.HagueJdbcTokenStore;
import com.harmonyit.shoppinglist.authservice.security.service.oauth2.InformationTokenEnhancer;
import com.harmonyit.shoppinglist.authservice.security.service.oauth2.MailAuthenticationKeyGenerator;

@Profile("!test")
@Configuration
@AutoConfigureOrder(JdbcTokenConfiguration.LOW_PRIORITY)
public class JdbcTokenConfiguration implements TokenConfiguration {

  // By default Spring security beans has order = 0
  /** The Constant LOW_PRIORITY. */
  static final int LOW_PRIORITY = -5;

  @Autowired
  private DataSource dataSource;

  @Override
  @Bean
  public TokenStore tokenStore() {
    JdbcTokenStore jdbcTokenStore = new HagueJdbcTokenStore(dataSource);
    // Defining custom token store to use mail in token information
    jdbcTokenStore.setAuthenticationKeyGenerator(authenticationKeyGenerator());
    return jdbcTokenStore;
  }

  @Override
  @Bean
  public AuthenticationKeyGenerator authenticationKeyGenerator() {
    return new MailAuthenticationKeyGenerator();
  }

  @Override
  @Bean
  public TokenEnhancer tokenEnhancer() {
    return new InformationTokenEnhancer();
  }

  @Override
  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    return defaultTokenServices;
  }

}
