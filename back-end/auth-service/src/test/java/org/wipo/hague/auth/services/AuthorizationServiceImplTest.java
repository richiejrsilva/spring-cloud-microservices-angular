package org.wipo.hague.auth.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.test.util.ReflectionTestUtils;

import com.harmonyit.shoppinglist.authservice.common.test.HagueTestConfiguration;
import com.harmonyit.shoppinglist.authservice.common.test.service.AbstractServiceTest;
import com.harmonyit.shoppinglist.authservice.security.db.UserRepository;
import com.harmonyit.shoppinglist.authservice.security.service.AuthorizationServiceImpl;

@Import({HagueTestConfiguration.class})
public class AuthorizationServiceImplTest extends AbstractServiceTest {

  @InjectMocks
  private AuthorizationServiceImpl authorizationServiceImpl;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  @Lazy
  @Qualifier("tokenServices")
  DefaultTokenServices tokenServices;


  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
    ReflectionTestUtils.setField(authorizationServiceImpl, "userRepository", userRepository);
    ReflectionTestUtils.setField(authorizationServiceImpl, "tokenServices", tokenServices);
  }

  @Test
  public void obtainRolesByEmailTest() {
    List<String> roles = authorizationServiceImpl.obtainRolesByEmail("hague-fo@test.com");
    assertFalse(roles.isEmpty());
    assertTrue(roles.contains("ROLE_GUESS"));
    assertTrue(roles.contains("FRONT"));
    assertTrue(roles.contains("BACK"));
  }

  @Test
  public void obtainUsernameByEmailTest() {
    String name = authorizationServiceImpl.obtainUsernameByEmail("hague-fo@test.com");
    assertTrue(name.equals("hague-fo"));
  }

  @Test
  public void existsEmailTest() {
    assertTrue(authorizationServiceImpl.existsEmail("hague-fo@test.com"));
  }
}
