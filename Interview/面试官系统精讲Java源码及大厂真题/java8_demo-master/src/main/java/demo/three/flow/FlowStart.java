package demo.three.flow;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 流程启动类
 * author  wenhe
 * date 2019/8/11
 */
@Slf4j
@Component
public class FlowStart {

  /**
   * 流程引擎开始
   *
   * @param flowName 流程的名字
   */
  public void start(String flowName, FlowContent content) {
    invokeParamValid(flowName, content);
    invokeBusinessValid(flowName, content);
    invokeInTramsactionValid(flowName, content);
    invokeAfterTramsactionValid(flowName, content);
  }

  private void invokeParamValid(String flowName, FlowContent content) {
    stageInvoke(flowName, StageEnum.PARAM_VALID, content);
  }

  private void invokeBusinessValid(String flowName, FlowContent content) {
    stageInvoke(flowName, StageEnum.BUSINESS_VALID, content);
  }

  private void invokeInTramsactionValid(String flowName, FlowContent content) {
    stageInvoke(flowName, StageEnum.IN_TRANSACTION, content);
  }

  private void invokeAfterTramsactionValid(String flowName, FlowContent content) {
    stageInvoke(flowName, StageEnum.AFTER_TRANSACTION, content);
  }

  private void stageInvoke(String flowName, StageEnum stage, FlowContent content) {
    List<DomainAbilityBean>
        domainAbilitys =
        FlowCenter.flowMap.getOrDefault(flowName, Maps.newHashMap())
            .getOrDefault(stage, Lists.newArrayList());
    if (CollectionUtils.isEmpty(domainAbilitys)) {
      //throw new RuntimeException("找不到该流程对应的领域行为" + flowName);
    }
    for (DomainAbilityBean domainAbility : domainAbilitys) {
//      domainAbility.invoke(content);
      ComponentExecutor.run(domainAbility,content);
    }
  }

}
