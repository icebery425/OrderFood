package com.worldunion.prophesy.service.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * 重写shiro处理访问被拒绝的方法，增加ajax请求判断
 *
 * Created by liuruiyan on 2017/9/6.
 */
public class UserSessionInvalidAuthenticationFilter extends FormAuthenticationFilter{

    private static final Logger log = LoggerFactory.getLogger(UserSessionInvalidAuthenticationFilter.class);


    /**
     * 请求被拒绝处理
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(this.isLoginRequest(request, response)) {
            if(this.isLoginSubmission(request, response)) {
                if(log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if(log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else {
            if(log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }

            //如果是ajax请求，则保存请求，然后返回session失效返回码与message
            if(isAjax(request)){

                //1.保存请求
                //this.saveRequest(request);

                //2.返回session失效状态码
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("returnCode","8088");
                jsonObject.put("returnMsg","");
                response.getWriter().write(JSON.toJSONString(jsonObject));

            }else{
                this.saveRequestAndRedirectToLogin(request, response);
            }

            return false;
        }
    }



    private static boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
