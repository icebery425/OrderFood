package com.worldunion.prophesy.utils.common;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by starhousexq on 2015/11/17.
 */
public class CollectionUtil extends org.apache.commons.collections.CollectionUtils{


    public static Map extractToMap(Collection collection, String keyPropertyName, String valuePropertyName) {
        Map map = new HashMap();

        try {
            for (Object obj : collection) {
                map.put(PropertyUtils.getProperty(obj, keyPropertyName),PropertyUtils.getProperty(obj, valuePropertyName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


    public static <T> List<T> extractToList(Collection collection, String propertyName) {

        return extractToList(collection,propertyName,false);
    }


    public static <T> List<T> extractToList(Collection collection, String propertyName,boolean ignoreEmptyValue) {
        if (collection == null) {
            return null;
        }
        List list = new ArrayList();

        try {
            for (Object obj : collection) {
                T value = (T) PropertyUtils.getProperty(obj, propertyName);
                if (ignoreEmptyValue && value == null || value.toString().equals("")) {
                    continue;
                }
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public static String extractToString(Collection collection, String propertyName, String separator) {
        List list = extractToList(collection, propertyName);
        return StringUtils.join(list, separator);
    }
    
    public static int getMaxByArray(List<Integer> list){
    	if(CollectionUtils.isEmpty(list)){
    		return 0;
    	}
		Collections.sort(list);
    	return list.get(list.size()-1);
    	
    }
}
