package com.worldunion.prophesy.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by 0155481 on 2016-09-20.
 */
public class Signature2Interceptor extends HandlerInterceptorAdapter {
	
	private Logger logger =  LoggerFactory.getLogger(Signature2Interceptor.class); 
	
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
//
//        String productId =request.getHeader("Product-Id");
//        String ak =request.getHeader("ak");
//
//        if(StringUtils.isBlank(productId) ){
//            throw  new   RuntimeException("产品编号不能为空");
//        }
//        if(StringUtils.isBlank(ak) ){
//            throw  new   RuntimeException("密钥不能为空");
//        }
//        try{
//         DesUtils desUtils = new DesUtils();
//            desUtils.decrypt(ak);
//        }catch (Exception e){
//            throw  new   RuntimeException("密钥验证错误");
//        }
//        
//        return true;
//    }

}
