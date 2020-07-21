package readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import readinglist.ReadingListApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ReadingListApplication.class)
@WebIntegrationTest(randomPort=true)
public class ServerWebTest {
  
  @Value("${local.server.port}")
  private int port;
  
  @Test
  public void testSomething() throws Exception {
    
    RestTemplate test = new RestTemplate();
    String s = test.getForObject("http://localhost:{port}", String.class, port);
    System.out.println(s);
  }

}
