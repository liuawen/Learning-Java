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

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * Zuul Filter工具类
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Component
public class FilterUtils {
    public static final String AUTH_TOKEN       = "Authorization";
    public static final String USER_ID          = "scd-user-id";
    public static final String SHOP_ID          = "scd-shop-id";
    public static final String PRE_FILTER_TYPE  = "pre";

    public final String getShopId(){
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRequest().getHeader(SHOP_ID) != null) {
            return ctx.getRequest().getHeader(SHOP_ID);
        } else {
            return ctx.getZuulRequestHeaders().get(SHOP_ID);
        }
    }

    public void setShopId(String shopId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(SHOP_ID, shopId);
    }

    public final String getUserId(){
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRequest().getHeader(USER_ID) !=null) {
            return ctx.getRequest().getHeader(USER_ID);
        } else {
            return  ctx.getZuulRequestHeaders().get(USER_ID);
        }
    }

    public void setUserId(String userId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(USER_ID, userId);
    }

    public final String getAuthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(AUTH_TOKEN);
    }
}
