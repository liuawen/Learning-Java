package com.springboot.entity;

import com.springboot.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages<T> {

    //页码
    Integer pageNumber;
    //分页索引
    Integer page;
    //每页数量
    Integer pageSize;


    public static Pages defaultPages(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        return new Pages(pageNumber, (pageNumber - 1) * Constants.defaultPageSize, Constants.defaultPageSize);
    }

    public static Pages defaultPages(Integer pageNumber,Integer pageSize) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        if (pageSize == null) {
            pageSize = Constants.defaultPageSize;
        }
        return new Pages(pageNumber, (pageNumber - 1) * pageSize, pageSize);
    }
}
