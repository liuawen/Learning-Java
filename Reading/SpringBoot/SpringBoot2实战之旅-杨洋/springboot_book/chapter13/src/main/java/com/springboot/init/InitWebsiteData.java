package com.springboot.init;

import com.springboot.entity.WebsiteAccess;
import com.springboot.entity.WebsiteConfig;
import com.springboot.service.WebsiteAccessService;
import com.springboot.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class InitWebsiteData {
    @Autowired
    private WebsiteAccessService websiteAccessService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @PostConstruct
    public void initWebsiteVisits(){
        //查询当日是否存在博客访问表记录，不存在则插入
        if(websiteAccessService.getByAccessDateIs(new Date()) == null){
            WebsiteAccess websiteAccess = new WebsiteAccess();
            websiteAccess.setAccessCount(1);
            websiteAccess.setAccessDate(new Date());
            websiteAccessService.save(websiteAccess);
        }
        //查询当日是否存在博客配置表记录，不存在则插入
        if(websiteConfigService.findWebsiteConfig()==null){
            WebsiteConfig websiteConfig = new WebsiteConfig();
            websiteConfig.setId(1L);
            websiteConfig.setAboutPageArticleId(7L);
            websiteConfig.setBlogName("SpringBoot博客");
            websiteConfig.setAuthorName("dalaoyang");
            websiteConfig.setDomainName("Dalaoyang.cn");
            websiteConfig.setRecordNumber("辽ICP备17014944号-1");
            websiteConfig.setEmailUsername("dalaoyang@aliyun.com");
            websiteConfigService.saveWebsiteConfig(websiteConfig);
        }
    }
}
