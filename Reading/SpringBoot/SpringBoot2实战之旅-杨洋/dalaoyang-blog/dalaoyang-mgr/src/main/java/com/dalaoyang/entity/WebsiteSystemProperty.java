package com.dalaoyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteSystemProperty implements Serializable {

    private static final long serialVersionUID = 7072433146386221989L;
    private String id;
    private String websiteUrl;
    private String websiteName;
    private String domainName;
    private String beianNumber;
    private String wechatName;
    private String weiboUrl;
    private String giteeUrl;
    private String emailUrl;
    private String csdnUrl;
    private String blogUrl;
    private String jianshuUrl;
    private String gongzhonghaoName;
    private String gongzhonghaoTrueName;
}
