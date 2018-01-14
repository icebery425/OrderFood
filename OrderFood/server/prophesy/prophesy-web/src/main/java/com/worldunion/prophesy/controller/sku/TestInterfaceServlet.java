package com.worldunion.prophesy.controller.sku;

import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.zip.GZIPOutputStream;  

import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


public class TestInterfaceServlet extends HttpServlet  
{  
      
    /** 
     * 对外接口主入口 
     * 用于获取用户请求，返回用户请求使用。 
     */  
    public void service(ServletRequest request, ServletResponse response)  
        throws ServletException, IOException  
    {  
        System.out.println("aaaa");
          
    }  
      
    /** 
     * 获取http头信息  
     * <功能详细描述> 
     * @param request 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public Map<String, String> getHeaderMap(HttpServletRequest request)  
    {  
        Map<String, String> map = new HashMap<String, String>();  
        if (null != request.getHeader("msgname") && !"".equals(request.getHeader("msgname")))  
            map.put("msgname", request.getHeader("msgname"));  
        if (null != request.getHeader("Accept-Encoding") && !"".equals(request.getHeader("Accept-Encoding")))  
            map.put("Accept-Encoding", request.getHeader("Accept-Encoding"));  
        if (null != request.getHeader("timestamp") && !"".equals("timestamp"))  
            map.put("timestamp", request.getHeader("timestamp"));  
        return map;  
    }  
      
    
      
    /** 
     * gZip压缩方法 
     * 将原报文通过gzip压缩 
     * @param data 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static byte[] gZip(byte[] data)  
    {  
        byte[] b = null;  
        try  
        {  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            GZIPOutputStream gzip = new GZIPOutputStream(bos);  
            gzip.write(data);  
            gzip.finish();  
            gzip.close();  
            b = bos.toByteArray();  
            bos.close();  
        }  
        catch (Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        return b;  
    }  
      
}  