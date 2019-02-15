package com.harmonyit.shoppinglist.authservice.security.service.oauth2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.util.Assert;

import com.harmonyit.shoppinglist.authservice.security.service.AuthorizationService;

// In openid - oauth2 flow used to authenticate and authorize users to use services, the stored
// tokens needs username information to generate authentication keys, this allow had multiple
// tokens with the same client, one for each user, storing the token with needed information
public class HagueJdbcTokenStore extends JdbcTokenStore {

  private static final Log LOG = LogFactory.getLog(HagueJdbcTokenStore.class);

  private final JdbcTemplate jdbcTemplate;

  private static final String DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT =
      "insert into oauth_access_token (token_id, token, authentication_id, user_name, client_id, authentication, refresh_token) values (?, ?, ?, ?, ?, ?, ?)";

  private static final String DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT =
      "select token_id, token from oauth_access_token where authentication_id = ?";

  private String selectAccessTokenFromAuthenticationSql = DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT;

  private String insertAccessTokenSql = DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT;

  private AuthenticationKeyGenerator authenticationKeyGenerator = new MailAuthenticationKeyGenerator();

  @Autowired
  private AuthorizationService authorizationService;

  public HagueJdbcTokenStore(DataSource dataSource) {
    super(dataSource);
    Assert.notNull(dataSource, "DataSource required");
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void setAuthenticationKeyGenerator(AuthenticationKeyGenerator authenticationKeyGenerator) {
    this.authenticationKeyGenerator = authenticationKeyGenerator;
  }

  @Override
  public void setSelectAccessTokenFromAuthenticationSql(String selectAccessTokenFromAuthenticationSql) {
    this.selectAccessTokenFromAuthenticationSql = selectAccessTokenFromAuthenticationSql;
  }

  @Override
  public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
    OAuth2AccessToken accessToken = null;

    String key = authenticationKeyGenerator.extractKey(authentication);
    try {
      accessToken =
          jdbcTemplate.queryForObject(selectAccessTokenFromAuthenticationSql, new RowMapper<OAuth2AccessToken>() {
            @Override
            public OAuth2AccessToken mapRow(ResultSet rs, int rowNum) throws SQLException {
              return deserializeAccessToken(rs.getBytes(2));
            }
          }, key);
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Failed to find access token for authentication " + authentication);
      }
    } catch (IllegalArgumentException e) {
      LOG.error("Could not extract access token for authentication " + authentication, e);
    }

    if (accessToken != null
        && !key.equals(authenticationKeyGenerator.extractKey(readAuthentication(accessToken.getValue())))) {
      removeAccessToken(accessToken.getValue());
      // Keep the store consistent (maybe the same user is represented by this authentication but
      // the details have
      // changed)
      storeAccessToken(accessToken, authentication);
    }
    return accessToken;
  }

  @Override
  public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
    String refreshToken = null;
    if (token.getRefreshToken() != null) {
      refreshToken = token.getRefreshToken().getValue();
    }

    if (readAccessToken(token.getValue()) != null) {
      removeAccessToken(token.getValue());
    }

    String username;
    if (authentication.getOAuth2Request().getRequestParameters().get("email") != null) {
      username = authorizationService
          .obtainUsernameByEmail(authentication.getOAuth2Request().getRequestParameters().get("email").toString());
    } else {
      username = authentication.isClientOnly() ? null : authentication.getName();
    }

    jdbcTemplate.update(insertAccessTokenSql,
        new Object[] {extractTokenKey(token.getValue()), new SqlLobValue(serializeAccessToken(token)),
            authenticationKeyGenerator.extractKey(authentication), username,
            // authentication.isClientOnly() ? null : authentication.getName(),
            authentication.getOAuth2Request().getClientId(), new SqlLobValue(serializeAuthentication(authentication)),
            extractTokenKey(refreshToken)},
        new int[] {Types.VARCHAR, Types.BLOB, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BLOB, Types.VARCHAR});
  }

}
