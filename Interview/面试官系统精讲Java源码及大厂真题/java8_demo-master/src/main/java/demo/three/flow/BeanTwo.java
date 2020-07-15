package demo.three.flow;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@AsyncComponent
@Component
@Slf4j
public class BeanTwo implements DomainAbilityBean {

  @Override
  public FlowContent invoke(FlowContent content) {
    log.info("BeanTwo is run,thread name is {}",Thread.currentThread().getName());
    return null;
  }
}
