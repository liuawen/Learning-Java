package demo.three.flow;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BeanOne implements DomainAbilityBean {

  @Override
  public FlowContent invoke(FlowContent content) {
    // 方法的入参从 FlowContent 里面拿
    log.info("BeanOne is run,thread name is {}",Thread.currentThread().getName());
    return null;
  }
}
