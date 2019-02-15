package com.harmonyit.shoppinglist.authservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harmonyit.shoppinglist.authservice.core.api.authorization.AuthorizationRestService;
import com.harmonyit.shoppinglist.authservice.security.service.AuthorizationServiceImpl;

/**
 * The Class {@link AuthorizationRestServiceImpl}.
 * <p>
 * This controller is just a REST access point to the business logic.
 */
@RestController
public class AuthorizationRestServiceImpl implements AuthorizationRestService {

  /** The authorization service. */
  @Autowired
  private AuthorizationServiceImpl authorizationService;

  /*
   * (non-Javadoc)
   *
   * @see
   * org.wipo.hague.core.api.authorization.AuthorizationRestService#revokeToken(java.lang.String)
   */
  @Override
  @PreAuthorize("hasRole('MANAGER')")
  public boolean revokeToken(final String token) {
    return authorizationService.revokeToken(token);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.wipo.hague.core.api.authorization.AuthorizationRestService#refreshToken(java.lang.String,
   * java.lang.String)
   */
  @Override
  public OAuth2AccessToken refreshToken(String refreshToken, String request) {
    return authorizationService.refreshToken(refreshToken, request);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.wipo.hague.core.api.authorization.AuthorizationRestService#existsEmail(java.lang.String)
   */
  @Override
  @PreAuthorize("hasRole('MANAGER') or hasRole('SUPERVISOR')")
  public boolean existsEmail(@RequestParam("email") final String email) {
    return authorizationService.existsEmail(email);
  }

}
