package com.harmonyit.shoppinglist.authservice.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.harmonyit.shoppinglist.authservice.security.db.UserRepository;

/**
 * It is used throughout the framework as a user DAO and is the strategy used by
 * the DaoAuthenticationProvider.
 * https://docs.spring.io/spring-security/site/docs/4.2.11.BUILD-SNAPSHOT/apidocs/org/springframework/security/core/userdetails/UserDetailsService.html
 * https://www.programcreek.com/java-api-examples/?code=sniperqpc/Spring-cloud-gather/Spring-cloud-gather-master/auth-service/src/main/java/com/piggymetrics/auth/config/AuthorizationServerConfiguration.java#
 */
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	/** The LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	public UserDetailsServiceImpl() {
		LOG.info("Instantiating {}", this.getClass().getName());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang. String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		//add comment it can connect to a ldap os db with users. i'm using a simple oracle db.
		//create a optional return in repo to to orElseThrow
		final com.harmonyit.shoppinglist.authservice.security.db.model.User user = userRepository.findByUserName(username).orElseThrow(() -> new RuntimeException("User not found: " + username));

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getAuthorities());
		
	}

}
