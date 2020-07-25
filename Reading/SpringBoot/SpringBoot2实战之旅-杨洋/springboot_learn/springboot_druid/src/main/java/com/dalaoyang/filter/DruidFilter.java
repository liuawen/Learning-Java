package com.dalaoyang.filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.filter
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/12
 */


@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)
public class DruidFilter extends WebStatFilter  {
}
