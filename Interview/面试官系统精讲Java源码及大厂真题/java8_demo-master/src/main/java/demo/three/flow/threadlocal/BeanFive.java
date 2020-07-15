package demo.three.flow.threadlocal;

import org.springframework.stereotype.Component;

import demo.three.flow.AsyncComponent;
import demo.three.flow.DomainAbilityBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AsyncComponent
@Component
public class BeanFive implements DomainAbilityBean {

  @Override
  public void invoke() {
    String value = ContextCache.getAttribute("key1");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("get 线程名称为{}, value is {}", Thread.currentThread().getName(),value);
    log.info("------------------");
  }
}
