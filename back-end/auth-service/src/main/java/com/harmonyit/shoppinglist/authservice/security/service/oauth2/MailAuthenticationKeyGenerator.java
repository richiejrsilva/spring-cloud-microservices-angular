package com.harmonyit.shoppinglist.authservice.security.service.oauth2;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;

import com.harmonyit.shoppinglist.authservice.security.service.AuthorizationService;

public class MailAuthenticationKeyGenerator implements AuthenticationKeyGenerator {

  private static final String CLIENT_ID = "client_id";

  private static final String SCOPE = "scope";

  private static final String USERNAME = "username";

  /** The LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(InformationTokenEnhancer.class);

  /** The user details service. */
  @Autowired
  private AuthorizationService authorizationService;

  @Override
  public String extractKey(OAuth2Authentication authentication) {
    Map<String, String> values = new LinkedHashMap<>();
    OAuth2Request authorizationRequest = authentication.getOAuth2Request();
    // If mail is finded in oauth2 request, get username from mail and setting into USERNAME value,
    // need to
    // will have multiple tokens for the same client with different user
    if (authentication.getOAuth2Request().getRequestParameters().get("email") != null) {
      LOGGER.debug("mail finded in oauth2 request, getting username from mail");
      String username = authorizationService
          .obtainUsernameByEmail(authentication.getOAuth2Request().getRequestParameters().get("email"));
      values.put(USERNAME, username);
    } else if (!authentication.isClientOnly()) {
      values.put(USERNAME, authentication.getName());
    }

    values.put(CLIENT_ID, authorizationRequest.getClientId());
    if (authorizationRequest.getScope() != null) {
      values.put(SCOPE, OAuth2Utils.formatParameterList(new TreeSet<>(authorizationRequest.getScope())));
    }
    return generateKey(values);
  }

  protected String generateKey(Map<String, String> values) {
    MessageDigest digest;
    try {
      digest = MessageDigest.getInstance("MD5");
      byte[] bytes = digest.digest(values.toString().getBytes("UTF-8"));
      return String.format("%032x", new BigInteger(1, bytes));
    } catch (NoSuchAlgorithmException nsae) {
      throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).", nsae);
    } catch (UnsupportedEncodingException uee) {
      throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).", uee);
    }
  }

}
