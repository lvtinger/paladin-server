package org.lvtinger.paladin.web.filter;

import org.apache.commons.lang3.StringUtils;
import org.lvtinger.paladin.web.core.PaladinThreadLocal;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "paladinFilter", urlPatterns = "/*")
public class PaladinFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            storeToken(request);
            chain.doFilter(request, response);
        } catch (Exception ignored) {

        } finally {
            cleanToken();
        }
    }

    private void storeToken(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            return;
        }
        PaladinThreadLocal.getInstance().set(token);
    }

    private void cleanToken() {
        PaladinThreadLocal.getInstance().remove();
    }
}
