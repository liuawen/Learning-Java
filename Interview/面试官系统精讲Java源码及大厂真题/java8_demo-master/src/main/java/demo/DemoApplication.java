package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.three.flow.ApplicationContextHelper;
import demo.three.flow.FlowContent;
import demo.three.flow.FlowStart;


/**
* DemoApplication
*author  wenhe
*date 2019/9/24
*/
@SpringBootApplication(scanBasePackages = {"demo"})
public class DemoApplication {

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(DemoApplication.class);
    for (int i = 0; i < 20; i++) {
      ApplicationContextHelper.getBean(FlowStart.class)
          .start("flow2", new FlowContent());
    }
  }


}
