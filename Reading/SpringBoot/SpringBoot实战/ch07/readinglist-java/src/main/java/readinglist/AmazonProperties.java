package readinglist;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon")
public class AmazonProperties {

  private String associateId;
  
  public void setAssociateId(String associateId) {
    this.associateId = associateId;
  }
  
  public String getAssociateId() {
    return associateId;
  }
  
}
