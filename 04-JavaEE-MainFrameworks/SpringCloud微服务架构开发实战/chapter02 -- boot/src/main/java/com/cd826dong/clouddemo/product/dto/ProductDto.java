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
package com.cd826dong.clouddemo.product.dto;

import com.cd826dong.clouddemo.product.entity.Product;
import com.cd826dong.clouddemo.product.entity.ProductComment;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 商品信息DTO定义
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@ApiModel(value = "商品信息包")
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    @ApiModelProperty(value="商品主键Id")
    private Long id;
    @ApiModelProperty(value="商品名称")
    private String name;
    @ApiModelProperty(value="商品封面图片")
    private String coverImage;
    @ApiModelProperty(value="商品价格(单位:分)")
    private int price;

    public ProductDto() {

    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.coverImage = product.getCoverImage();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName());
    }

    // ========================================================================
    // setter/getter ==========================================================
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}