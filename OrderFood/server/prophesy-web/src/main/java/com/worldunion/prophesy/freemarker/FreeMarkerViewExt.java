package com.worldunion.prophesy.freemarker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worldunion.prophesy.service.base.ServiceConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;



import freemarker.template.SimpleHash;

@Component
public class FreeMarkerViewExt extends FreeMarkerView {
	@Override
	protected SimpleHash buildTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		//上下文
		model.put("ctx", request.getContextPath());
		ServiceConfigurer configurer = (ServiceConfigurer) ContextLoader.getCurrentWebApplicationContext().getBean("serviceConfigurer");
//		model.put("STATIC_RESOURCE", configurer.getStaticResource());
		model.put("CTX_TIME", System.currentTimeMillis());
		return super.buildTemplateModel(model, request, response);
	}
}
