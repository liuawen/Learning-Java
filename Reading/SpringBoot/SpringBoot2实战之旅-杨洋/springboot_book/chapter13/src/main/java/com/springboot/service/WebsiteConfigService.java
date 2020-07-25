package com.springboot.service;

import com.springboot.entity.WebsiteConfig;

public interface WebsiteConfigService {

    WebsiteConfig findWebsiteConfig();

    void saveWebsiteConfig(WebsiteConfig websiteConfig);
}
