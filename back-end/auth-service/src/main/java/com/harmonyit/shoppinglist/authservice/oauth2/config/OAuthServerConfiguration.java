package com.harmonyit.shoppinglist.authservice.oauth2.config;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.harmonyit.shoppinglist.authservice.oauth2.config.OAuth2ClientsConfiguration.Client;

/**
 * https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection?utm_source=hs_email&utm_medium=email&utm_content=69687638&_hsenc=p2ANqtz-8C93QEfzDF_dm4rj7JGiQSOo4En2iV7Nudr9tO_08rYjVq1k57rftCyxDOYZbZ2W3WzZP0Vep5F_a5aTImImell6IecA&_hsmi=69687640
 * @author richard.silva
 *
 */
@Configuration
@DependsOn({ "authServerSecurityConfiguration", "oAuth2ClientsConfiguration" })
public class OAuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	/** The LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(OAuthServerConfiguration.class);

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenEnhancer tokenEnhancer;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private OAuth2ClientsConfiguration clientsConfiguration;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	 /* (non-Javadoc)
 	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
 	 *
 	 * Clients loaded from yml file
 	 *
 	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
		
		LOG.info("Clients found in configuration : {}", clientsConfiguration.getClients().size());
		
		if (!clientsConfiguration.getClients().isEmpty()) {
			
			for (Client client : clientsConfiguration.getClients()) {
				
				builder.withClient(client.getClientId())
				.secret(passwordEncoder.encode(client.getClientSecret()))
				.accessTokenValiditySeconds(client.getExpirationMinutes())
				.refreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds())
				.authorizedGrantTypes(client.getAuthorizedGrantTypes())
				.scopes(client.getScopes());
				//.resourceIds("api")
				
			}
			
		}
	
	 }

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer));
		endpoints.tokenStore(tokenStore).tokenEnhancer(tokenEnhancerChain).authenticationManager(authenticationManager);
	}
	

	/**
	 * Spring Security OAuth exposes two endpoints for checking tokens (/oauth/check_token and /oauth/token_key). 
	 * Those endpoints are not exposed by default (have access "denyAll()").
	 * To verify the tokens with this endpoint you'll have to add this to your authorization servers' config:
	 * oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	 * This config is usually useful when your resources servers are not on the same application. A microservies architecture is an example 
	 * 
	 * http://projects.spring.io/spring-security-oauth/docs/oauth2.html#resource-server-configuration
	 * 
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}
}
