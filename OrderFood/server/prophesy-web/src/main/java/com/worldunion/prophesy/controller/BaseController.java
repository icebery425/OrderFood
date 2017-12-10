package com.worldunion.prophesy.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.worldunion.prophesy.model.account.Staff;
import com.worldunion.prophesy.model.util.SystemVariableUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BaseController {
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    public HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest().getSession();
    }

    public ServletContext getServletContext() {
        return ContextLoader.getCurrentWebApplicationContext()
                .getServletContext();
    }


    public Staff getCurrentStaff(){
        return SystemVariableUtils.getSessionVariable().getStaff();
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
     * 获取request 参数
     *
     * @return
     */
    public Map<String, Object> getArrayQueryParams() {
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	Map map = getRequest().getParameterMap();
    	Set keys = map.keySet();
    	for (Object key : keys) {
    		String[] strArr = getRequest().getParameterValues(key.toString());
    		if(strArr.length>0){
    			parameters.put(key.toString(),strArr);
    		}
    	}
    	return parameters;
    }

    //------------------------------获取查询参数----------------------------------
    public String getString(String name, String defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr == null || "".equals(resultStr)
                || "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return defaultValue;
        } else {
            return resultStr;

        }
    }

    public String getString(String name) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr == null || "".equals(resultStr)
                || "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return null;
        } else {
            return resultStr;

        }
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


    public String getRemoteIp() {
        return getRequest().getRemoteAddr();
    }

    public String formatIds(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            String[] arr = ids.split(",");

            StringBuffer sb = new StringBuffer();

            for (String id : arr) {
                sb.append("'");
                sb.append(id);
                sb.append("'");
                sb.append(",");
            }


            return sb.substring(0, sb.length() - 1);


        }
        return null;

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    
    /**
	 * 从cookie中取值
	 * @return
	 */
	public String getCookieValueByName(String cookieName){
		String value = null;
		//读取所有cookie信息
		Cookie cookies[]=getRequest().getCookies();
		if(cookies == null) return null;
		//遍历cookie
		for(int i=0;i<cookies.length;i++){
			Cookie cookie=cookies[i];
			if(cookieName.equals(cookie.getName())){
				value = cookie.getValue();
			}
		}
		
		return StringUtils.isBlank(value)?"":value.toString();
	}


    /**
     * 判断参数是否为空
     * @param params
     * @return
     */
    public static boolean isNotNull(String... params){
        for (String string: params) {
            if(StringUtils.isBlank(string)){
                return false;
            }
        }
        return true;
    }


    /**
     * 设置cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, String path,String domain,int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath(path);
        cookie.setDomain(domain);
        if(maxAge>0)  cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 受信任的身份验证 （tableau）
     * @param wgserver
     * @param user
     * @param remoteAddr
     * @return
     * @throws ServletException
     */
    // the client_ip parameter isn't necessary to send in the POST unless you have
    // wgserver.extended_trusted_ip_checking enabled (it's disabled by default)
    protected String getTrustedTicket(String wgserver, String user, String remoteAddr)
            throws ServletException
    {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        try {
            // Encode the parameters
            StringBuffer data = new StringBuffer();
            data.append(URLEncoder.encode("username", "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(user, "UTF-8"));
            if(StringUtils.isNotBlank(remoteAddr)){
                data.append("&");
                data.append(URLEncoder.encode("client_ip", "UTF-8"));
                data.append("=");
                data.append(URLEncoder.encode(remoteAddr, "UTF-8"));
            }

            // Send the request
            URL url = new URL("http://" + wgserver + "/trusted");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(data.toString());
            out.flush();

            // Read the response
            StringBuffer rsp = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ( (line = in.readLine()) != null) {
                rsp.append(line);
            }

            return rsp.toString();

        } catch (Exception e) {
            throw new ServletException(e);
        }
        finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            }
            catch (IOException e) {}
        }
    }
    public void getPageParams(Map<String, Object> param){
    	String pageIndex=String.valueOf(param.get("pageIndex"));
		String pageSize=String.valueOf(param.get("pageSize"));
		if(pageIndex!=null && !"".equals(pageIndex)&&pageSize!=null && !"".equals(pageSize)){
			param.put("start", (Integer.parseInt(pageIndex)-1)*Integer.parseInt(pageSize));
			param.put("end", Integer.parseInt(pageSize));
		}
    }

}
