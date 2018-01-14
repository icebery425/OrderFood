package com.worldunion.prophesy.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 该工具类用于提供map、bean、json相互转换的功能。
 * 只用于特定的业务框架工具类满足不了时候才写到该类中。
 * @author lishangjiang
 */
public class ConvertUtil { 
	
	
	/**
	 * copyProperties方法使用案例
	 */
	/*public static void main(String[] args) {
		
		B b = new B();
		b.name = "aa";
		B b2 = new B();
		
		copyProperties(b, b2, new String[]{"name"});
		System.out.println(b2.name);
	}*/
	
	/**
	 * copyProperties方法使用案例
	 */
/*	public static void main(String[] args) {
		ConvertUtil util = new ConvertUtil();
		B b = new B();
		b.name = "aaa";
		C c = new C();
		
		copyProperties(b, new String[]{"name"}, c, new String[]{"value"});
		System.out.println(c.value);
	}*/
	
	/**
	 * convertBeans方法使用案例
	 */
	public static void main(String[] args) {
		
		List<B> arr = new ArrayList<B>();
		
		B e = new B();
		e.name = "aaa";
		
		arr.add(e);
		
		List<C> bs = ConvertUtil.convertBeans(arr, new String[]{"name"}, C.class, new String[]{"value"});
		
		System.out.println(bs.get(0).value);
	}
	
	
	/**
	 * ConvertListToMap方法使用案例
	 */
/*	public static void main(String[] args){
		A  a = new A(new B("a", "b"));
		//B b = new B("a");
		
		List<A> list = new ArrayList<A>();
		list.add(a);
		
		Map<String, A> map = convertListToMap(list, ":", "b.name", "b.age");
		
		for(Map.Entry<String, A> entry : map.entrySet()){
			System.out.println("key="+entry.getKey());
			System.out.println("name="+entry.getValue());
		}
	}*/
	
	
	
	/**
	 * 进行特定的属性copy
	 * @param source 原对象
	 * @param target 目标对象
	 * @param properties 复制的属性，暂不支持osnl表达式
	 */
	public static void copyProperties(Object source, Object target, String[] properties){
		
		copyProperties(source, properties, target, null);
	}
	
	/**
	 * 将bean集合转换成另外一个Bean
	 * @param sources	
	 * @param sourceProperties
	 * @param clazz
	 * @param targetPropertes
	 */
	public static <T> List<T> convertBeans(List<? extends Serializable> sources, String[] sourceProperties, Class<T> targetClazz, String[] targetPropertes){
		
		List<T> beans = new ArrayList<T>();
		
		try {
			for(Serializable s : sources){
				
				T t = targetClazz.newInstance();
				
				copyProperties(s, sourceProperties, t, targetPropertes);
				
				beans.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		return beans;
	}
	
	/**
	 * 进行特定的属性copy
	 * @param source 原对象
	 * @param target 目标对象
	 * @param sourceProperties	原对象的属性，暂不支持osnl表达式
	 * @param targetPropertes	目标对象的属性，暂不支持osnl表达式
	 */
	public static void copyProperties(Object source, String[] sourceProperties, Object target,  String[] targetPropertes){
		
		//如果参数不存在，则直接返回
		if(source==null || target==null)	return;
		
		//如果指定复制的属性不存在，则直接全部copy
		if(sourceProperties==null || sourceProperties.length==0) BeanUtils.copyProperties(source, target);
		
		for(int i=0; i<sourceProperties.length; i++){	//将包含的属性进行复制
			
			Field sourceField = ReflectionUtils.findField(source.getClass(), sourceProperties[i]);
			Field targetField = ReflectionUtils.findField(target.getClass(), targetPropertes == null || targetPropertes.length <= i ? sourceProperties[i] : targetPropertes[i]);
			
			if(sourceField==null || targetField==null) continue;
			
			sourceField.setAccessible(true);
			targetField.setAccessible(true);
			
			try {
				targetField.set(target, sourceField.get(source));
			} catch (Exception e) {
				new RuntimeException(e);
			} 
		}
	}
	
	/**
	 * 功能：将list转换成map
	 * @param resource 需要转换的数据源
	 * @param separator 拼装的分隔符
	 * @param fieldNameOgnls 指定map的key值属性
	 * @return
	 */
	public static <T> Map<String, T> convertListToMap(List<T> resource, String separator, String... fieldNameOgnls){
		
		//如果没有转换的数据源，或者没有指定字段的值，则返回null
		if(resource==null || fieldNameOgnls==null || fieldNameOgnls.length==0) return null;
		
		Map<String, T> result = new HashMap<String, T>();
		
		for(T obj : resource){
			
			StringBuffer key = new StringBuffer();
			
			for(int i=0; i<fieldNameOgnls.length; i++){
				
				String val = (String)ReflectionUtil.getValueByField(obj, fieldNameOgnls[i], null);
						
				key.append(fieldNameOgnls.length-1==i?val:val+separator);
			}
			
			result.put(key.toString(), obj);
		}
		return result;
	}
	
	/**
	 * 功能：将list转换成map
	 * @param resource 需要转换的数据源
	 * @param fieldNameOgnl	指定map的key值属性
	 * @param append 与fieldNameOgnl的值组成key
	 * @return
	 */
	public static <T> Map<String, T> convertListToMap(List<T> resource, String fieldNameOgnl, String append){
		
		//如果没有转换的数据源，或者没有指定字段的值，则返回null
		if(resource==null || !StringUtils.hasText(fieldNameOgnl)) return null;
		
		Map<String, T> result = new HashMap<String, T>();
		
		for(T obj : resource){
			result.put(String.valueOf(ReflectionUtil.getValueByField(obj, fieldNameOgnl, null) + append), obj);
		}
		return result;
	}
	 
	
	/**
	 * 功能：将list转换成map
	 * @param resource 需要转换的数据源
	 * @param fieldNameOgnl	指定map的key值属性
	 * @return
	 */
	public static <T> Map<String, T> convertListToMap(List<T> resource, String fieldNameOgnl){
		return convertListToMap(resource, fieldNameOgnl, "");
	}
	
	/**
	 * 功能：将bean集合转换成Map集合
	 * @param resources 转换的原对象集合
     * @param resourceFieldName 需要转换原的字段
     * @param mappingFieldName  需要转换的映射字段
	 * @return map集合
	 */
	public static List<Map<String, Object>> convertToMap(List<?> resources, String[] resourceFieldName, String[] mappingFieldName, ConvertFormat format){
		
		if(resources == null) return null;
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		for(Object object : resources){
			result.add(convertToMap(object, resourceFieldName, mappingFieldName, format));
		}
		
		return result;
	}
	
    /**
     * 功能（可以加强）：将bean转换成map
     * 注意：
     * 该功能只支持resourceFieldName到mappingFieldName字段的转换
     * 不支持resourceFieldName为null的转换
     * @param resource 转换的原对象
     * @param resourceFieldName 需要转换原的字段
     * @param mappingFieldName  需要转换的映射字段
     * @return map数据
     */
    public static Map<String, Object> convertToMap(Object resource, String[] resourceFieldName, String[] mappingFieldName, ConvertFormat format){ 
        
    	if(resource == null) return null;
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	
		for(int i=0; i<resourceFieldName.length; i++){
			
			if(mappingFieldName==null || mappingFieldName.length<=i){	//转换时候是否需要转换成映射字段名称
				result.put(resourceFieldName[i], ReflectionUtil.getValueByField(resource, resourceFieldName[i], format));
			}else{
				result.put(mappingFieldName[i], ReflectionUtil.getValueByField(resource, resourceFieldName[i], format));
			}
		}
        return result; 
    }

	/**
	 * 功能（可以加强）：将bean转换成map
	 * 注意：
	 * 该功能只支持resourceFieldName到mappingFieldName字段的转换
	 * 不支持resourceFieldName为null的转换
	 * @param resource 转换的原对象
	 * @return map数据
	 */
	public static Map<String, Object> convertToMap(Object resource){

		if(null==resource){
			return null;
		}
		Field[] fields = resource.getClass().getDeclaredFields();
		List resourceFieldName = new ArrayList();
		for(Field field : fields){
			if(!Modifier.isStatic(field.getModifiers())){
				resourceFieldName.add(field.getName());
			}
		}

		return convertToMap(resource, (String[])resourceFieldName.toArray(new String[resourceFieldName.size()]), null, null);
	}
    
    
    
    
  
}

class A {
	@SuppressWarnings("unused")
	private B b;

	public A(B b) {
		super();
		this.b = b;
	}
	
}

class B implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4913032403096384842L;

	public String name;
	
	public String age;
	
	public B(){}

	public B(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "B [name=" + name + ", age=" + age + "]";
	}
	
}

class C {
	
	public String value;
	
}