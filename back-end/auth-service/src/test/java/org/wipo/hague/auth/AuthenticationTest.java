package org.wipo.hague.auth;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetails;

import com.harmonyit.shoppinglist.authservice.common.test.HagueTestConfiguration;
import com.harmonyit.shoppinglist.authservice.common.test.service.AbstractServiceTest;
import com.harmonyit.shoppinglist.authservice.security.service.DbUserDetailsServiceImpl;

/**
 * The Class AuthenticationTest.
 */
@Import(HagueTestConfiguration.class)
public class AuthenticationTest extends AbstractServiceTest {

  /** The local server port. */
  @LocalServerPort
  private int localServerPort;

  /** The client ID. */
  @Value("${security.oauth2.client.clientId}")
  private String clientId;

  /** The client secret. */
  @Value("${security.oauth2.client.clientSecret}")
  private String clientSecret;

  /** The DB user details service impl. */
  @Autowired
  private DbUserDetailsServiceImpl dbUserDetailsServiceImpl;

  /**
   * Tests OAuth2.
   */
  @Test
  public void testOAuth2() {
    // Act
    // For this test we need authentication so we are getting the token from this very server
    final String token = GetTokenUtil.getBearerToken("system", "Everis.2017", localServerPort, clientId, clientSecret);

    // Assert that we are getting a not null token
    Assert.assertEquals("Bearer 57f48a00-5c22-4c3e-b061-b4dcb8466e2e".length(), token.trim().length());
  }

  /**
   * Tests the method "loadUserByUsername".
   */
  @Test
  public void testLoadUserByUsername() {
    // Act
    final UserDetails user = dbUserDetailsServiceImpl.loadUserByUsername("system");

    // Assert
    Assert.assertNotNull("Unexpected user", user);
  }
}
