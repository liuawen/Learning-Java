/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cd826dong.clouddemo.product.service;


import com.cd826dong.clouddemo.product.entity.Product;
import com.cd826dong.clouddemo.product.entity.ProductComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 产品管理服务
 *
 * @author CD826
 * @since 1.0.0
 */
public interface ProductService {
    /**
     * 获取商品配置的分页数据
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<Product> getPage(Pageable pageable);

    /**
     * 加载指定的商品配置
     * @param id 商品配置ID
     * @return
     */
    Product load(Long id);

    /**
     * 加载指定商品的评论列表
     * @param productId
     * @return
     */
    List<ProductComment> findAllByProduct(Long productId);
}
