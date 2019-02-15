package com.harmonyit.shoppinglist.authservice.security.service.oauth2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.harmonyit.shoppinglist.authservice.security.service.AuthorizationService;

public class InformationTokenEnhancer implements TokenEnhancer {

  /** The LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(InformationTokenEnhancer.class);

  @Autowired
  private AuthorizationService authorizationService;

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    // If mail is finded in oauth2 request, get roles from mail and adding to authorities in
    // additional info
    if (authentication.getOAuth2Request().getRequestParameters().get("email") != null) {
      LOGGER.debug("finded mail in oauth2 request, adding roles from this mail");
      String email = authentication.getOAuth2Request().getRequestParameters().get("email");
      final Map<String, Object> additionalInfo = new HashMap<>();
      List<String> listGrant = authorizationService.obtainRolesByEmail(email);

      additionalInfo.put("authorities", listGrant);
      additionalInfo.put("user_name", authorizationService.obtainUsernameByEmail(email));

      ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
    }

    return accessToken;
  }

}
