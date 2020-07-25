package com.springboot.timer;

import com.springboot.entity.WebsiteAccess;
import com.springboot.service.WebsiteAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WebSiteTimer {
    @Autowired
    private WebsiteAccessService websiteAccessService;
    @Scheduled(cron = "0 0 0 1/1 * ?")
    private void updateTodayWebsiteVisits() {
        WebsiteAccess websiteAccess = new WebsiteAccess();
        websiteAccess.setAccessCount(1);
        websiteAccess.setAccessDate(new Date());
        websiteAccessService.save(websiteAccess);
    }
}
