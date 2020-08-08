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
package com.cd826dong.clouddemo.util;

/**
 * 用户上下文信息
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
public class UserContext {
    public static final String AUTH_TOKEN     = "Authorization";
    public static final String USER_ID        = "scd-user-id";
    public static final String SHOP_ID        = "scd-shop-id";

    private static final ThreadLocal<String> authToken= new ThreadLocal<String>();
    private static final ThreadLocal<String> userId = new ThreadLocal<String>();
    private static final ThreadLocal<String> shopId = new ThreadLocal<String>();

    public static String getAuthToken() {
        return authToken.get();
    }
    public static void setAuthToken(String curToken) {
        authToken.set(curToken);
    }

    public static String getUserId() {
        return userId.get();
    }
    public static void setUserId(
            String curUserId) {userId.set(curUserId);
    }

    public static String getShopId() {
        return shopId.get();
    }
    public static void setShopId(String curShopId) {
        shopId.set(curShopId);
    }
}