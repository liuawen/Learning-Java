package demo.three.flow;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import demo.three.flow.threadlocal.BeanFive;
import demo.three.flow.threadlocal.BeanThree;
import lombok.extern.slf4j.Slf4j;

/**
 * FlowCenter
 * author  wenhe
 * date 2019/8/11
 */
@Slf4j
@Component
public class FlowCenter {

  /**
   * flowMap 是共享变量，方便访问
   */
  public static final Map<String, Map<StageEnum, List<DomainAbilityBean>>> flowMap
      = Maps.newConcurrentMap();

  /**
   * PostConstruct 注解的意思就是
   * 在容器启动成功之后，初始化 flowMap
   */
  @PostConstruct
  public void init() {
      // 初始化 flowMap mock
    Map<StageEnum, List<DomainAbilityBean>> stageMap = flowMap.getOrDefault("flow1",Maps.newConcurrentMap());
    for (StageEnum value : StageEnum.values()) {
      List<DomainAbilityBean> domainAbilitys = stageMap.getOrDefault(value, Lists.newCopyOnWriteArrayList());
      if(CollectionUtils.isEmpty(domainAbilitys)){
        domainAbilitys.addAll(ImmutableList.of(
            ApplicationContextHelper.getBean(BeanOne.class),
            ApplicationContextHelper.getBean(BeanTwo.class)
        ));
        stageMap.put(value,domainAbilitys);
      }
    }
    flowMap.put("flow1",stageMap);

    // 初始化流程2
    Map<StageEnum, List<DomainAbilityBean>> stageMap2 = flowMap.getOrDefault("flow2",Maps.newConcurrentMap());
    List<DomainAbilityBean> list2 = stageMap2.getOrDefault(StageEnum.PARAM_VALID,Lists.newArrayList());
    list2.add(ApplicationContextHelper.getBean(BeanThree.class));
    list2.add(ApplicationContextHelper.getBean(BeanFive.class));
    stageMap2.put(StageEnum.PARAM_VALID,list2);
    flowMap.put("flow2",stageMap2);

    log.info("init success,flowMap is {}", JSON.toJSONString(flowMap));
  }
}
