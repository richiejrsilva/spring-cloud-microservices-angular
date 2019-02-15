package org.wipo.hague.auth;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The Class GetTokenUtil.
 */
public class GetTokenUtil {

  /** The logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(GetTokenUtil.class);

  /** The Constant PORT. */
  private static final int PORT = 8999;

  /** The Constant USER. */
  private static final String USER = "dataentry1";

  /** The Constant PASSWORD. */
  private static final String PASSWORD = "Everis.2017";

  /** The Constant CLIENT. */
  private static final String CLIENT = "trustedclient";

  /** The Constant SECRET. */
  private static final String SECRET = "trustedclient123";

  /** The Constant TEMPLATE. */
  private static final RestTemplate TEMPLATE = new RestTemplate();

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(final String[] args) {
    getBearerToken(USER, PASSWORD, PORT, CLIENT, SECRET);
  }

  /**
   * Gets the bearer token.
   *
   * @param user the user
   * @param password the password
   * @param port the port
   * @param clientId the client id
   * @param clientSecret the client secret
   * @return the bearer token
   */
  public static String getBearerToken(final String user, final String password, final int port, final String clientId,
      final String clientSecret) {

    final MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
    form.set("username", user);
    form.set("password", password);
    form.set("grant_type", "password");

    final String basicAuthHeader =
        "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());

    final HttpHeaders headers = new HttpHeaders();
    headers.put("Authorization", Arrays.asList(basicAuthHeader));

    final URI uri = URI.create("http://localhost:" + port + "/oauth/token");

    // Other values:
    // URI.create("http://hppoc.appls.org/gateway-fo/hague-auth/oauth/token");
    // URI.create("http://hague-public-api/gateway-fo/hague-auth/oauth/token");

    final ResponseEntity<String> result =
        TEMPLATE.exchange(new RequestEntity<>(form, headers, HttpMethod.POST, uri), String.class);

    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.getBody()).isNotNull();

    final String token =
        "Bearer " + StringUtils.split(StringUtils.split(result.getBody(), ",")[0], ":")[1].replaceAll("\"", "");

    LOGGER.info("TOKEN: " + token);

    return token;
  }
}
