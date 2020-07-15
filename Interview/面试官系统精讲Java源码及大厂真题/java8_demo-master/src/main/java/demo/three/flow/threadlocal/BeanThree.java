package demo.three.flow.threadlocal;

import org.springframework.stereotype.Component;

import java.util.Random;

import demo.three.flow.DomainAbilityBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BeanThree implements DomainAbilityBean {

  @Override
  public void invoke() {
    int i = new Random().nextInt(1000);
    ContextCache.putAttribute("key1", "value"+i);
    log.info("put key1,value{}",i);
  }
}
