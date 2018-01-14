package com.worldunion.prophesy.controller.base;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Created by 0141434 on 2016-07-19.
 */
public class BaseController {
	
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    public ServletContext getServletContext() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

    public int getInt(String name) {
        return getInt(name, 0);
    }

    public int getInt(String name, int defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr != null) {
            try {
                return Integer.parseInt(resultStr);
            } catch (Exception e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public BigDecimal getBigDecimal(String name) {
        return getBigDecimal(name, null);
    }

    public BigDecimal getBigDecimal(String name, BigDecimal defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr != null) {
            try {
                return BigDecimal.valueOf(Double.parseDouble(resultStr));
            } catch (Exception e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public String getString(String name) {
        return getString(name, null);
    }

    public String getString(String name, String defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr == null || "".equals(resultStr) || "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return defaultValue;
        } else {
            return resultStr;
        }
    }

    /**
     * 获取request 参数
     *
     * @return
     */
    public Map<String, Object> getQueryParams() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = getRequest().getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {

            if (StringUtils.isNotEmpty(getRequest().getParameter(key.toString()))) {
                parameters.put(key.toString(),
                        getRequest().getParameter(key.toString()));
            }
        }
        return parameters;
    }

    /**
     * 取得所以的参数
     *
     * @param request
     * @return
     */
    protected Map<String, Object> requstParamToMap(HttpServletRequest request) {
        final Map<String, Object> result = new HashMap<String, Object>();

        final Map<?, ?> paramMap = request.getParameterMap();
        for (Map.Entry<?, ?> e : paramMap.entrySet()) {
            final Object key = e.getKey();
            final Object value = e.getValue();

            if (!(key instanceof String)) {
                continue;
            }
            if (null == value) {
                continue;
            }
            if (!(value instanceof String || value instanceof String[])) {
                continue;
            }
            if (value instanceof String) {
                result.put((String) key, (String) value);
                continue;
            }
            final String[] vs = (String[]) value;
            if (vs.length == 0) {
                continue;
            }
            if (vs.length == 1) {
                result.put((String) key, vs[0]);
                continue;
            }
            result.put((String) key, value);
        }

        return result;
    }
    /**
     * 添加Model消息
     * @param messages
     */
    protected void addMessage(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages){
            sb.append(message).append(messages.length>1?"<br/>":"");
        }
        model.addAttribute("message", sb.toString());
    }

    /**
     * 添加Flash消息
     * @param messages
     */
    protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages){
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        redirectAttributes.addFlashAttribute("message", sb.toString());
    }
}
