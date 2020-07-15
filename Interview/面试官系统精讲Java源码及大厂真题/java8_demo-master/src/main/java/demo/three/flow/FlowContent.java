package demo.three.flow;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
* 流程上下文
*author  wenhe
*date 2019/8/11
*/
@Data
public class FlowContent implements Serializable{

  private static final long serialVersionUID = -1368014678785056855L;

  /**
   * 入参数
   */
  private Object request;

  /**
   * 出参
   */
  private Object response;

  public static void main(String[] args) {
    /**
     * 第一个 key 是流程的名字
     * 第二个 map 的 key 是阶段，为 StageEnum 枚举，值为多个领域行为的集合
     */
    Map<String,Map<StageEnum,List<DomainAbilityBean>>> map = Maps.newHashMap();
  }
}
