package demo.sixth;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 * 根据商品 ID 进行退款
 */
@Slf4j
public class RefundDemo {

  /**
   * 根据商品 ID 进行退款
   * @param itemId
   * @return
   */
  public boolean refundByItem(Long itemId) {
    try {
      // 线程沉睡 30 毫秒，模拟单个商品退款过程
      Thread.sleep(30);
      log.info("refund success,itemId is {}", itemId);
      return true;
    } catch (Exception e) {
      log.error("refundByItemError,itemId is {}", itemId);
      return false;
    }
  }
}
