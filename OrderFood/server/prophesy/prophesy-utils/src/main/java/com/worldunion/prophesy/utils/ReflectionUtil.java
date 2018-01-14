package com.worldunion.prophesy.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * 该工具类用于提供针对反射提供的服务
 * 只用于特定的业务框架工具类满足不了时候才写到该类中。
 * @author lishangjiang
 */
public class ReflectionUtil {

	/**
     * 获得字段的值
     * @param obj 对象 
     * @param fieldNameOgnl 字段名称，支持ognl表达式的搜索
     * @param format 字段值的格式化器
     * @return 字段的值
     */
	public static Object getValueByField(Object obj, String fieldNameOgnl, ConvertFormat format){
    	
    	Object result = null;
    	
    	Field f = null;
		try {
			
			//搜索字段是否是ognl表达式
			Boolean isOgnl = fieldNameOgnl.indexOf(".")!=-1;
			
			//搜索字段
			f = ReflectionUtils.findField(obj.getClass(), isOgnl ? fieldNameOgnl.substring(0, fieldNameOgnl.indexOf(".")) : fieldNameOgnl);
			f.setAccessible(true);	//压制访问级别
			
			if(isOgnl){	
				//如果搜索的字段是ognl表达式	,则递归搜索字段
				result = getValueByField(f.get(obj), fieldNameOgnl.substring(fieldNameOgnl.indexOf(".")+1), null);
			}else{
				if(format!=null){	
					//转换格式化器
					result = format.format(obj, f, f.get(obj));
				}else{
					result =  f.get(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException();
		} 
		return result;
    } 
}
