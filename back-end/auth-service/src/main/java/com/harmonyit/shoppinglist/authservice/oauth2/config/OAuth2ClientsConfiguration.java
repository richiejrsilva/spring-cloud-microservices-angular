package com.harmonyit.shoppinglist.authservice.oauth2.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("oAuth2ClientsConfiguration")
@ConfigurationProperties(prefix = "oauth2")
@EnableConfigurationProperties
public class OAuth2ClientsConfiguration {

  private List<Client> clients = new ArrayList<>();

  public List<Client> getClients() {
    return clients;
  }

  public static class Client {
	  
    private String name;
    private String[] authorizedGrantTypes;
    private String clientId;
    private String clientSecret;
    private String[] scopes;
    private Integer expirationMinutes;
    private Integer refreshTokenValiditySeconds;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String[] getAuthorizedGrantTypes() {
      return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String[] authorizedGrantTypes) {
      this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getClientId() {
      return clientId;
    }

    public void setClientId(String clientId) {
      this.clientId = clientId;
    }

    public String getClientSecret() {
      return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
    }

    public String[] getScopes() {
      return scopes;
    }

    public void setScopes(String[] scopes) {
      this.scopes = scopes;
    }

    public Integer getExpirationMinutes() {
      return expirationMinutes;
    }

    public void setExpirationMinutes(Integer expirationMinutes) {
      this.expirationMinutes = expirationMinutes;
    }

	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}
	
	 @Override
	    public String toString() {
	      return "Client{" + "name='" + name + '\'' + ", types='" + Arrays.toString(authorizedGrantTypes) + '\'' + ", clientId='"
	          + clientId + '\'' + ", clientSecret='" + clientSecret + '\'' + ", scopes='" + Arrays.toString(scopes) + '\''
	          + ", expirationMinutes='" + expirationMinutes.toString() + '\'' + '}';
	    }
	 
  }
}
