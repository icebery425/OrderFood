package com.worldunion.prophesy.interceptor;

import com.worldunion.prophesy.utils.excel.ExcelConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by liuruiyan on 2017/4/19.
 */
public class BaseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ExcelConfig.setProjectName(request.getContextPath());
        //System.out.println("***********用户session ID："+SecurityUtils.getSubject().getSession().getId());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
