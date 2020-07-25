package com.dalaoyang.util;


import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.dao.TagDao;
import com.dalaoyang.dao.WebsiteSystemPropertyDao;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.entity.TagInfo;
import com.dalaoyang.entity.WebsiteSystemProperty;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.dalaoyang.consts.Consts.PAGE_SIZE;

@Component
public class SitemapUtil {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    @Autowired
    private WebsiteSystemPropertyDao websiteSystemPropertyDao;

    public String createSitemap() throws Exception {

        WebsiteSystemProperty websiteSystemProperty = websiteSystemPropertyDao.getWebsiteSystemProperty();
        String DOMAIN_URL = websiteSystemProperty.getWebsiteUrl();

        String xmlurl = "";
        Element urlset = new Element("urlset");
        Document document = new Document(urlset);

        List<String> listStr = new ArrayList<String>();

        //1.导航菜单链接
        listStr.add(DOMAIN_URL);
        listStr.add(DOMAIN_URL + "about");
        listStr.add(DOMAIN_URL + "contact");
        listStr.add(DOMAIN_URL + "search?word=");
        listStr.add(DOMAIN_URL + "error");

        //2.首页分页参数
        List<ArticleInfo> articleInfoList = articleDao.getArticleListForSitemap();
        int indexPageCount = articleInfoList.size() % PAGE_SIZE > 0 ? (articleInfoList.size() / PAGE_SIZE + 1) : (articleInfoList.size() / PAGE_SIZE);
        for (int i = 1; i <= indexPageCount; i++) {
            listStr.add(DOMAIN_URL + i);
        }

        //3.文章链接
        for (ArticleInfo articleInfo : articleInfoList) {
            listStr.add(DOMAIN_URL + "article/" + articleInfo.getArticleId());
        }

        //4.标签链接
        List<TagInfo> tagInfoList = tagDao.getTagList();
        for (TagInfo tagInfo : tagInfoList) {
            String tagName = tagInfo.getTagName();
            listStr.add(DOMAIN_URL + "tag/" + tagName);
            int totalCount = articleDao.getArticleByTagCount(tagName);
            int pageCount = totalCount % PAGE_SIZE > 0 ? (totalCount / PAGE_SIZE + 1) : (totalCount / PAGE_SIZE);
            if (pageCount > 1) {
                for (int i = 1; i < pageCount; i++) {
                    listStr.add(DOMAIN_URL + "tag/" + tagName + "/" + i);
                }
            }
        }

        for (String str : listStr) {
            Element url = new Element("url");
            Element loc = new Element("loc");
            loc.setText(str);
            url.addContent(loc);
            Element lastmod = new Element("lastmod");
            lastmod.setText(sdf.format(new Date()));
            url.addContent(lastmod);
            Element changefreq = new Element("changefreq");
            changefreq.setText("daily");
            url.addContent(changefreq);
            urlset.addContent(url);
        }
        XMLOutputter XMLOut = new XMLOutputter();
        String path = System.getProperty("user.home") + "/sitemap.xml";
        File file = new File(path);
        try {
            Format f = Format.getPrettyFormat();
            f.setEncoding("UTF-8");
            XMLOut.setFormat(f);
            XMLOut.output(document, new FileOutputStream(path));
            aliyunOssUtil.siteMapUpload(file);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(file) && file.exists()) {
                file.delete();
            }
        }
        return xmlurl;
    }
}
