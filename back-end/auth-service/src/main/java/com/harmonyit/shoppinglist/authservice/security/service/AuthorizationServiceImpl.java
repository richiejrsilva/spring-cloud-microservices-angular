package com.harmonyit.shoppinglist.authservice.security.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

import com.harmonyit.shoppinglist.authservice.security.db.UserRepository;
import com.harmonyit.shoppinglist.authservice.security.db.model.UserJPA;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

  /** The logger. */

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
  /** The user repository. */
  @Autowired
  private UserRepository userRepository;

  @Autowired
  @Lazy
  @Qualifier("tokenServices")
  DefaultTokenServices tokenServices;

  /*
   * (non-Javadoc)
   *
   * @see org.wipo.hague.auth.services.AdministrationService#revokeToken(java.util.String)
   */
  @Override
  public boolean revokeToken(String token) {
    if (token != null) {
      OAuth2AccessToken oAuth2AccessToken = tokenServices.readAccessToken(token);
      if (oAuth2AccessToken != null) {
        tokenServices.revokeToken(token);
        return true;
      }

    }
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.wipo.hague.auth.services.AdministrationService#refreshToken(java.util.String,
   * org.springframework.security.oauth2.provider.OAuth2Request)
   */
  @Override
  public OAuth2AccessToken refreshToken(String token, String request) {
    if (token != null) {
      ObjectMapper mapper = new ObjectMapper();
      TokenRequest tokenRequest;
      try {
        tokenRequest = mapper.readValue(request, TokenRequest.class);

        return tokenServices.refreshAccessToken(token, tokenRequest);
      } catch (IOException e) {
        LOGGER.info(e.toString());
      }
    }
    return null;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.wipo.hague.auth.services.AdministrationService#obtainRolesByEmail(java.util.String)
   */
  @Override
  public List<String> obtainRolesByEmail(final String email) {
    UserJPA userJPA = userRepository.findByEmail(email);

    final List<String> grantedAuthorities =
        userJPA.getRoles().stream().map(roleJPA -> new String(roleJPA.getCode())).collect(Collectors.toList());

    grantedAuthorities.addAll(userJPA.getRoles().stream().map(roleJPA -> roleJPA.getPermissions())
        .flatMap(permissions -> permissions.stream()).map(permissionJPA -> new String(permissionJPA.getCode()))
        .collect(Collectors.toList()));

    return grantedAuthorities;
  }


  /*
   * (non-Javadoc)
   *
   * @see org.wipo.hague.auth.services.AdministrationService#obtainUsernameByEmail(java.util.String)
   */
  @Override
  public String obtainUsernameByEmail(final String email) {
    return userRepository.findByEmail(email).getExternalKey();
  }

  /*
   * (non-Javadoc)
   *
   * @see org.wipo.hague.auth.services.AdministrationService#existsEmail(java.util.String)
   */
  @Override
  public Boolean existsEmail(final String email) {
    UserJPA userJPA = userRepository.findByEmail(email);

    return userJPA != null ? true : false;
  }

}
