package com.harmonyit.shoppinglist;

import org.junit.Assert;
import org.junit.Test;

import com.harmonyit.shoppinglist.authservice.common.test.auto.PackageTest;

/**
 * The Class AutomatedTest.
 */
public class AutomatedTest {

  /**
   * Tests the classes.
   */
  @Test
  public void testClasses() {
    try {

      // Act
      PackageTest.execute("org.wipo.hague.auth.db.model");

      // Assert
      Assert.assertTrue("Test finished", true);

    } catch (final Exception e) {
      e.printStackTrace();

      // Assert fail
      Assert.fail("Test failed: " + e.getMessage());
    }
  }
}
