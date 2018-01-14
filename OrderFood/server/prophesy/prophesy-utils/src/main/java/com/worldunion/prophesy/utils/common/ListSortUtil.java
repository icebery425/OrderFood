package com.worldunion.prophesy.utils.common;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ListSortUtil {
	@SuppressWarnings({ "unchecked", "rawtypes" })  
    public static void sort(List<Map<String,Object>> targetList, final String sortField) {  
      
		 Collections.sort(targetList, new Comparator<Map<String, Object>>(){  
			  
             public int compare(Map<String, Object> o1, Map<String, Object> o2) {  
            	 Double name1 =Double.valueOf(String.valueOf(o1.get(sortField)));//name1是从你list里面拿出来的一个  
            	 Double name2= Double.valueOf(String.valueOf(o2.get(sortField))); //name1是从你list里面拿出来的第二个name      
              return name2.compareTo(name1);    
         }  
               
            });  
    }  
}
