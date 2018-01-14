package com.worldunion.prophesy.utils.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListSortUtilTest {
	public static void main(String[] args) {  
		  
        
        List<Map<String,Object>> targetList = new ArrayList<Map<String,Object>>();  
        Map<String,Object> m1=new HashMap<String,Object>();
        m1.put("id", 1);
        m1.put("name", "test1");
        m1.put("age", 4111);
        targetList.add(m1);  
        Map<String,Object> m2=new HashMap<String,Object>();
        m2.put("id", 2);
        m2.put("name", "test2");
        m2.put("age", 21);
        targetList.add(m2);  
        Map<String,Object> m3=new HashMap<String,Object>();
        m3.put("id", 3);
        m3.put("name", "test5");
        m3.put("age", 61);
        targetList.add(m3);  
        Map<String,Object> m4=new HashMap<String,Object>();
        m4.put("id", 4);
        m4.put("name", "test5");
        m4.put("age", 11);
        targetList.add(m4);  
        System.out.println("排序前: " + targetList);  
          
        ListSortUtil sortList = new ListSortUtil();  
        sortList.sort(targetList, "age");  
        System.out.println("排序后：" +targetList);  
  
    }  
  
}
