package com.harmonyit.shoppinglist.authservice.oauth2.config;

import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

public interface TokenConfiguration {

  public TokenStore tokenStore();

  public AuthenticationKeyGenerator authenticationKeyGenerator();

  public TokenEnhancer tokenEnhancer();

  public DefaultTokenServices tokenServices();

}
