package readinglist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import readinglist.TestUtilitiesTest.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class,
    initializers=ConfigFileApplicationContextInitializer.class)
public class TestUtilitiesTest {

  @Autowired
  Environment env;
  
  @Test
  public void loadProperties() {
    
    assertEquals("bar", env.getProperty("foo"));
    assertEquals("123", env.getProperty("bar"));
    
  }
  
  
  @Configuration
  public static class TestConfig {
  }
}
