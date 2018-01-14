package com.worldunion.prophesy.utils.common;

import java.lang.reflect.Field;

/**
 * 转换字段的格式化类，配合ConvertUtil使用 
 * @author lishangjiang
 */
public abstract class ConvertFormat {
	
	/**
	 * 格式化字段
	 * @param field 格式化的字段
	 * @param value 格式化的值
	 * @return 返回格式化的值
	 */
	public abstract Object format(Object source, Field field, Object value) throws Exception;
	
}
