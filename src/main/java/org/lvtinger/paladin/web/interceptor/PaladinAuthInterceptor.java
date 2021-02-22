package org.lvtinger.paladin.web.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.lvtinger.paladin.value.Result;
import org.lvtinger.paladin.web.core.PaladinThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaladinAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        if(StringUtils.isEmpty(servletPath)){
            return true;
        }
        if(servletPath.startsWith("/identity") || servletPath.startsWith("/error")){
            return true;
        }
        if(StringUtils.isEmpty(PaladinThreadLocal.getInstance().get())){
            response.getWriter().write(JSON.toJSONString(Result.auth()));
            return false;
        } else {
            return true;
        }
    }
}