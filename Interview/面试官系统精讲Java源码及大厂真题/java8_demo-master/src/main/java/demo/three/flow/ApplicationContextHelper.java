package demo.three.flow;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextHelper
 * author  wenhe
 * date 2019/3/21
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    ApplicationContextHelper.applicationContext = applicationContext;
  }

  public static <T> T getBean(Class<T> targetClz) {
    T beanInstance = null;
    //byType
    try {
      beanInstance = (T) applicationContext.getBean(targetClz);
    } catch (Exception e) {
    }
    //byName
    if (beanInstance == null) {
      String simpleName = targetClz.getSimpleName();
      simpleName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
      beanInstance = (T) applicationContext.getBean(simpleName);
    }
    if (beanInstance == null) {
      throw new RuntimeException(
          "beanName " + targetClz.getSimpleName()
          + " can not be found in ApplicationContext (byType and byName)");
    }
    return beanInstance;
  }
}
