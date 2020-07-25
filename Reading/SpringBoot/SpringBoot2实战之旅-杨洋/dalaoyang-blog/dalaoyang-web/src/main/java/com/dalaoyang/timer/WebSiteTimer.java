package com.dalaoyang.timer;

import com.dalaoyang.dao.WebsiteAccessInfoDao;
import com.dalaoyang.dao.WebsiteSystemInfoDao;
import com.dalaoyang.entity.WebsiteSystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebSiteTimer {

    @Autowired
    private WebsiteSystemInfoDao websiteSystemInfoDao;

    @Autowired
    private WebsiteAccessInfoDao websiteAccessInfoDao;

    @Scheduled(cron = "0 0 0 1/1 * ?")
    private void updateTodayWebsiteVisits() {
        WebsiteSystemInfo websiteSystemInfo = websiteSystemInfoDao.getWebsiteSystemInfo();
        websiteAccessInfoDao.saveTodayWebsiteAccessInfo(websiteSystemInfo.getTodayWebsiteVisits());
        websiteSystemInfoDao.updateTodayWebsiteVisits();
    }

    @Scheduled(cron = "0 0 0 1 * ?")
    private void updateMonthWebsiteVisits() {
        websiteSystemInfoDao.updateMonthWebsiteVisits();
    }

}
