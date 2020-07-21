package readinglist;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
  }
  
  @Override
  public void addArgumentResolvers(
      List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
  }
  
}
