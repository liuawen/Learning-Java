package demo.three.flow;

/**
 * 领域行为 author  wenhe date 2019/8/11
 */
public interface DomainAbilityBean {

  /**
   * 领域行为的方法入口
   */
  default FlowContent invoke(FlowContent content) {
    return content;
  }

  /**
   * 领域行为的方法入口2
   */
  default void invoke(){

  }
}
