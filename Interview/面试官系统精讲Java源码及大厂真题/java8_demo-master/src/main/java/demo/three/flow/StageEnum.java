package demo.three.flow;

import lombok.Getter;

/**
 * 流程的阶段，步骤
 * author  wenhe
 * date 2019/8/11
 */
@Getter
public enum StageEnum {

  PARAM_VALID("PARAM_VALID", "参数校验"),

  BUSINESS_VALID("BUSINESS_VALID", "业务校验"),

  IN_TRANSACTION("IN_TRANSACTION", "事务中落库"),

  AFTER_TRANSACTION("AFTER_TRANSACTION", "事务后事件"),
  ;

  private String code;
  private String desc;

  StageEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

}
