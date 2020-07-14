package com.imooc.springboot.databasecp.controller;

import com.imooc.springboot.databasecp.service.TransactionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2019/10/14
 */
@Api
@Slf4j
@RestController("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/batchinsert")
    public void batchInsert() {
        transactionService.batchInsert();
    }
}
