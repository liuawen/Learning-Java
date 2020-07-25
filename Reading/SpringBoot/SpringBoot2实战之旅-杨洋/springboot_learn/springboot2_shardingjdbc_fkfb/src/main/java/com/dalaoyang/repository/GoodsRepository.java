package com.dalaoyang.repository;

import com.dalaoyang.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yangyang
 * @date 2019/1/29
 */
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    List<Goods> findAllByGoodsIdBetween(Long goodsId1,Long goodsId2);

    List<Goods> findAllByGoodsIdIn(List<Long> goodsIds);
}
