package com.worldunion.prophesy.freemarker;

import java.io.IOException;
import java.io.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


public class FreemarkerTemplateExceptionHandler implements TemplateExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(FreemarkerTemplateExceptionHandler.class);

	public void handleTemplateException(TemplateException te, Environment env,Writer out) throws TemplateException {
		try {
			out.write("<p name ='_FK_ERROR_NAME' class=\"color_red\" title=\""+te.getMessage()+"\">页面异常 </p>");
			logger.error("[Freemarker Error: " + te.getMessage() + "]");
		} catch (IOException e) {
			logger.warn(e.getMessage());
			throw new TemplateException("Failed to print error message. Cause: " + e, env);
		}
	}
}
