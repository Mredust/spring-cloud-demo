package com.mredust.orderservice.sentinel;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: HeaderOriginParser
 * @author: Mredust
 * @date: 2025-09-27 23:36
 **/
@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String origin = httpServletRequest.getHeader("origin");
        if (StringUtils.isEmpty(origin)) {
            origin = "blank";
        }
        return origin;
    }
}
