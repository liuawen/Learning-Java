package com.xuecheng.framework.domain.cms;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 10:00.
 * @Modified By:
 */
@Data
@ToString
@Document(collection = "cms_site_server")
public class CmsSiteServer {
    /**
     * 站点id、服务器IP、端口、访问地址、服务器类型（代理、静态、动态、CDN）、资源发布地址（完整的HTTP接口）、使用类型（测试、生产）
     */
    //站点id
    private String siteId;
    //服务器ID
    @Id
    private String serverId;
    //服务器IP
    private String ip;
    //端口
    private String port;
    //访问地址
    private String webPath;
    //服务器名称（代理、静态、动态、CDN）
    private String serverName;
    //资源发布地址（完整的HTTP接口）
    private String uploadPath;
    //使用类型（测试、生产）
    private String useType;
}
