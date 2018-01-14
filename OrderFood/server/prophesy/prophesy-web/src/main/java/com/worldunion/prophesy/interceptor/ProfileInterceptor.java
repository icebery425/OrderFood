package com.worldunion.prophesy.interceptor;


import com.worldunion.prophesy.service.base.ServiceConfigurer;
import com.worldunion.prophesy.utils.diagnostic.Profiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Profile性能分析拦截器
 *
 */
public class ProfileInterceptor extends HandlerInterceptorAdapter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ServiceConfigurer configurer;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Profiler.clear();
		if(handler instanceof HandlerMethod){
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Profiler.start(handlerMethod.getMethod().getDeclaringClass().getName() + "." + handlerMethod.getMethod().getName());
		}else{
			Profiler.start("Profile Start");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
		Profiler.release();
		long duration = Profiler.getDuration();
		int threshold = configurer.getProfileThreshold() == null ? 1000 : configurer.getProfileThreshold();
		if (duration > threshold) {
			logger.warn(Profiler.dump());
		}
		Profiler.clear();
	};

}
