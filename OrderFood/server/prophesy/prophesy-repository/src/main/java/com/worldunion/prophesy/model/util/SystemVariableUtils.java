package com.worldunion.prophesy.model.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * 系统变量工具类
 *
 */
@Component
public class SystemVariableUtils {
	
	static public String DEFAULT_DICTIONARY_VALUE = "无";
	
	
	/**
	 * 获取当前系统常用Session变量实体
	 * 
	 * @return {@link SessionVariable}
	 */
	public static SessionVariable getSessionVariable() {

		Subject subject = SecurityUtils.getSubject();
		
		if (subject != null && subject.getPrincipals() != null) {
			return subject.getPrincipals().oneByType(SessionVariable.class);
		}
		
		return null;
	}
	
	/**
	 * 创建一个shiro的session,如果存在session就用现有的session，否则创建一个新的session
	 * 
	 * @return {@link Session}
	 */
	public static Session createSessionIfNull() {
		Session session = getSession();
		
		if (session == null) {
			session = getSession(true);
		}
		
		return session;
	}
	
	/**
	 * 获取shiro的session
	 * 
	 * @return {@link Session}
	 */
	public static Session getSession() {
		return getSession(false);
	}
	
	/**
	 * 
	 * 获取shiro的session
	 * 
	 * @param create true表示如果不存在，就创建，否则用现有的
	 * 
	 * @return {@link Session}
	 */
	public static Session getSession(boolean create) {
		return SecurityUtils.getSubject().getSession(create);
	}
	
	/**
	 * 判断当前会话是否登录
	 * 
	 * @return boolean
	 */
	public static boolean isAuthenticated() {
		return SecurityUtils.getSubject().isAuthenticated();
	}
	
}
