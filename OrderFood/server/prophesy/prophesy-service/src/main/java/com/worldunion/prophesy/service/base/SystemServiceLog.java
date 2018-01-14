package com.worldunion.prophesy.service.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface SystemServiceLog {    
    
	 String description()  default "";
	    String logTypeCode() default "";
	    String  logActionCode() default "";
	    String funcCode() default "";
	    String tableName() default "";
    
    
}    
