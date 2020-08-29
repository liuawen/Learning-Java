package com.tensquare.encrypt.filters;

import com.google.common.base.Strings;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.HttpServletRequestWrapper;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import com.tensquare.encrypt.rsa.RsaKeys;
import com.tensquare.encrypt.service.RsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

@Component
public class RSARequestFilter extends ZuulFilter {

    @Autowired private RsaService rsaService;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        /**
         * 1. 从request body中读取出加密后的请求参数
         * 2. 将加密后的请求参数用私钥解密
         * 3. 将解密后的请求参数写回request body中
         * 4. 转发请求
         */

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        try {

            String decryptData = null;
            HashMap dataMap = null;
            String token = null;

            String url = request.getRequestURL().toString();
            InputStream stream = ctx.getRequest().getInputStream();
            String requestParam = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));

            if(!Strings.isNullOrEmpty(requestParam)) {
                System.out.println(String.format("请求体中的密文: %s", requestParam));
                decryptData = rsaService.RSADecryptDataPEM(requestParam, RsaKeys.getServerPrvKeyPkcs8());

                System.out.println(String.format("解密后的内容: %s", decryptData));
            }

            System.out.println(String.format("request: %s >>> %s, data=%s", request.getMethod(), url, decryptData));

            if(!Strings.isNullOrEmpty(decryptData)) {
                System.out.println("json字符串写入request body");
                final byte[] reqBodyBytes = decryptData.getBytes();
                ctx.setRequest(new HttpServletRequestWrapper(request) {
                    @Override
                    public ServletInputStream getInputStream() throws IOException {
                        return new ServletInputStreamWrapper(reqBodyBytes);
                    }

                    @Override
                    public int getContentLength() {
                        return reqBodyBytes.length;
                    }

                    @Override
                    public long getContentLengthLong() {
                        return reqBodyBytes.length;
                    }
                });
            }

            System.out.println("转发request");
            // 设置request请求头中的Content-Type为application/json，否则api接口模块需要进行url转码操作
            ctx.addZuulRequestHeader("Content-Type", String.valueOf(MediaType.APPLICATION_JSON) + ";charset=UTF-8");

        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "运行出错" + e.getMessage());
        }

        return null;
    }
}