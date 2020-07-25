package com.dalaoyang.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class UrlPathFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Object requestURI = requestContext.get(FilterConstants.REQUEST_URI_KEY);
        Object server = requestContext.get(FilterConstants.PROXY_KEY);
        String finalURI = "/" + server + requestURI;
        requestContext.put(FilterConstants.REQUEST_URI_KEY, finalURI);
        return null;
    }
}
