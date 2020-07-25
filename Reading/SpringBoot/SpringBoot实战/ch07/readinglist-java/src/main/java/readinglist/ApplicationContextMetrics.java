package readinglist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ApplicationContextMetrics implements PublicMetrics {

  private ApplicationContext context;

  @Autowired
  public ApplicationContextMetrics(ApplicationContext context) {
    this.context = context;
  }
  
  @Override
  public Collection<Metric<?>> metrics() {
    List<Metric<?>> metrics = new ArrayList<Metric<?>>();
    metrics.add(new Metric<Long>("spring.context.startup-date", 
           context.getStartupDate()));
    metrics.add(new Metric<Integer>("spring.beans.definitions", 
           context.getBeanDefinitionCount()));
    metrics.add(new Metric<Integer>("spring.beans", 
           context.getBeanNamesForType(Object.class).length));
    metrics.add(new Metric<Integer>("spring.controllers", 
           context.getBeanNamesForAnnotation(Controller.class).length));
    return metrics;
  }
  
}
