package com.dalaoyang.timer;

import com.dalaoyang.util.SitemapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SitemapTimer {

    @Autowired
    private SitemapUtil sitemapUtil;

    @Value("${blog.sitemap.enabled}")
    private Boolean isEnabledSitemap;

    @Scheduled(cron = "0 0 0 1/1 * ?")
    private void createSitemap() throws Exception {
        if(isEnabledSitemap){
            sitemapUtil.createSitemap();
        }
    }
}
