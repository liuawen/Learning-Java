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


import com.cd826dong.clouddemo.product.entity.ProductComment;
import com.cd826dong.clouddemo.user.dto.UserDto;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品评论信息DTO定义
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@ApiModel(value = "商品评论信息包")
public class ProductCommentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    @ApiModelProperty(value="评论主键Id")
    private Long id;
    @ApiModelProperty(value="所属商品")
    private ProductDto product;
    @ApiModelProperty(value="评论作者")
    private UserDto author;
    @ApiModelProperty(value="评论内容")
    private String content;
    @ApiModelProperty(value="创建时间")
    private Date created;

    public ProductCommentDto() {

    }

    public ProductCommentDto(ProductComment productComment) {
        this.id = productComment.getId();
        this.content = productComment.getContent();
        this.created = productComment.getCreated();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("productId", getProduct());
    }

    // ========================================================================
    // setter/getter ==========================================================
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }
    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public UserDto getAuthor() {
        return author;
    }
    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
}