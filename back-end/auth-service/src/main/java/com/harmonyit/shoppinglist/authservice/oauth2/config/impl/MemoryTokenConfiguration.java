package com.harmonyit.shoppinglist.authservice.oauth2.config.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.harmonyit.shoppinglist.authservice.oauth2.config.TokenConfiguration;
import com.harmonyit.shoppinglist.authservice.security.service.oauth2.InformationTokenEnhancer;
import com.harmonyit.shoppinglist.authservice.security.service.oauth2.MailAuthenticationKeyGenerator;

@Configuration
@Profile("test") // Only for test popouses
public class MemoryTokenConfiguration implements TokenConfiguration {

  @Override
  @Bean
  public TokenStore tokenStore() {
    InMemoryTokenStore inMemoryTokenStore = new InMemoryTokenStore();
    // Defining custom token store to use mail in token information
    inMemoryTokenStore.setAuthenticationKeyGenerator(authenticationKeyGenerator());
    return inMemoryTokenStore;
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
    return defaultTokenServices;
  }

}
