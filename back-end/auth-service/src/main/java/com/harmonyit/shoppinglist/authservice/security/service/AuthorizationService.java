package com.harmonyit.shoppinglist.authservice.security.service;

import java.util.List;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 * The Interface AuthorizationService.
 */
public interface AuthorizationService {

  /**
   * Revokes the token access token
   *
   * @param token the token
   * @return true if successful, false otherwise
   */
  boolean revokeToken(String token);

  /**
   * Refresh the access token
   *
   * @param token the refreshToken
   * @param request the original request
   * @return OAuth2AccessToken new aaccess token
   */
  OAuth2AccessToken refreshToken(String refreshToken, String request);

  /**
   * Obtains the usernames that have the specified roles.
   *
   * @return the details of roles
   */
  List<String> obtainRolesByEmail(String email);

  /**
   * Obtains the username of the specified email.
   *
   * @return username
   */
  String obtainUsernameByEmail(String email);

  /**
   * Check if exists email.
   *
   * @return true or false
   */
  Boolean existsEmail(String email);

}
