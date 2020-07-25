package com.dalaoyang.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CacheController {

    @GetMapping("/deleteCache_tagList")
    @CrossOrigin
    @CacheEvict(value = "tagList", allEntries = true)
    public String deleteCacheTagList() {
        return "cache";
    }

    @GetMapping("/deleteCache_linkList")
    @CrossOrigin
    @CacheEvict(value = "linkList", allEntries = true)
    public String deleteCacheLinkList() {
        return "cache";
    }

    @GetMapping("/deleteCache_tag")
    @CrossOrigin
    @CacheEvict(value = "tag", allEntries = true)
    public String deleteCacheTag() {
        return "cache";
    }

    @GetMapping("/deleteCache_index")
    @CrossOrigin
    @CacheEvict(value = "index", allEntries = true)
    public String deleteCacheIndex() {
        return "cache";
    }

    @GetMapping("/deleteCache_indexCount")
    @CrossOrigin
    @CacheEvict(value = "indexCount", allEntries = true)
    public String deleteCacheIndexCount() {
        return "cache";
    }

    @GetMapping("/deleteCache_tagname")
    @CrossOrigin
    @CacheEvict(value = "tagname", allEntries = true)
    public String deleteCacheTagName() {
        return "cache";
    }

    @GetMapping("/deleteCache_tagCount")
    @CrossOrigin
    @CacheEvict(value = "tagCount", allEntries = true)
    public String deleteCacheTagCount() {
        return "cache";
    }

    @GetMapping("/deleteCache_websiteProperty")
    @CrossOrigin
    @CacheEvict(value = "WebsiteSystemProperty", allEntries = true)
    public String deleteCacheWebsiteProperty() {
        return "cache";
    }

    @GetMapping("/deleteAllCache")
    @CrossOrigin
    @CacheEvict(value = {"tagCount", "tagname", "indexCount", "index", "tag", "linkList", "tagList", "WebsiteSystemProperty"}, allEntries = true)
    public String deleteAllCache() {
        return "cache";
    }

}
