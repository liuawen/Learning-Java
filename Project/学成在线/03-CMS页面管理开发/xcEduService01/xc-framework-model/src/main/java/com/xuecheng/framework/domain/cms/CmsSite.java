package com.xuecheng.framework.domain.cms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.List;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 9:46.
 * @Modified By:
 */
@Data
@ToString
@Document(collection = "cms_site")
public class CmsSite {

    //站点ID
    @Id
    private String siteId;
    //站点名称
    private String siteName;
    //站点名称
    private String siteDomain;
    //站点端口
    private String sitePort;
    //站点访问地址
    private String siteWebPath;
    //创建时间
    private Date siteCreateTime;

}
