/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cd826dong.clouddemo.zuul.filters;

import com.cd826dong.clouddemo.zuul.config.ServiceConfig;
import com.netflix.zuul.ZuulFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 解析店铺的Id示例Filter
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Component
public class JWTTokenFilter extends ZuulFilter{
    private static final int      FILTER_ORDER =  1;

    @Autowired
    private FilterUtils filterUtils;

    @Autowired
    private ServiceConfig serviceConfig;

    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        this.parseJWTToken();
        return null;
    }

    /**
     * 解析JWT Token中的信息
     * @return
     */
    private void parseJWTToken(){
        if (null == filterUtils.getAuthToken())
            return;

        String authToken = filterUtils.getAuthToken().replace("bearer ","");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(serviceConfig.getJwtSigningKey().getBytes("UTF-8"))
                    .parseClaimsJws(authToken).getBody();
            filterUtils.setShopId((String) claims.get("shopId"));
            filterUtils.setUserId((String) claims.get("user_name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}