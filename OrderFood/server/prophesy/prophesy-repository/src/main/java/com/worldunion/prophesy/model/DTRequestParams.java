package com.worldunion.prophesy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * dataTable请求参数bean
 * @author 0155481
 */
public class DTRequestParams {

	private Integer draw ;  
    
    private Integer start;  
      
    private Integer length;  
      
    private Map<Search, String> search = new HashMap<Search, String>();  
  
    private List<Map<Order, String>> order = new ArrayList<Map<Order, String>>();  
  
    private List<Map<Column, String>> columns = new ArrayList<Map<Column, String>>();  
  
    private Map<String, Object> reqParams = new HashMap<String, Object>();
    
    public DTRequestParams() {  
          
    }  
    public enum Search {  
        value,  
        regex  
    }  
  
    public enum Order {  
        column,  
        dir  
    }  
  
    public enum Column {  
        data,  
        name,  
        searchable,  
        orderable,  
        searchValue,  
        searchRegex  
    }

    
    /**
     * 获取dataTable插件参数中的分页和排序参数
     * @return
     */
    public Map<String, Object> getPaginationAndOrderByParam(){
    	
    	Integer startNum = getStart()+1;
    	Integer endNum = getStart()+getLength();
    	String orderByClause = null;
    	List<Map<Order, String>> order = getOrder();
    	if(order!=null && order.size()>0){
    		//列id
    		Integer columnId = Integer.parseInt(order.get(0).get(DTRequestParams.Order.column).toString());
    		//asc、desc
    		String dir = (String)order.get(0).get(DTRequestParams.Order.dir);
    		
    		List<Map<Column, String>> cloumn = getColumns();
    		//列名
    		String columnName = cloumn.get(columnId).get(DTRequestParams.Column.data);
    		if(StringUtils.isNotBlank(columnName) && StringUtils.isNotBlank(dir)){
    			if(columnName.contains("parceltrade.")){
    				orderByClause = columnName.replace("parceltrade.", "")+" "+dir;
    			}else{
    				orderByClause = columnName+" "+dir;
    			}
    		}
    	}
    	
    	Map<String, Object> reqMap = new HashMap<String, Object>();
    	
    	reqMap.put("start", startNum);
    	reqMap.put("end", endNum);
    	reqMap.put("orderByClause", orderByClause);
    	
    	return reqMap;
    }
    
    
    
    
    
	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Map<Search, String> getSearch() {
		return search;
	}

	public void setSearch(Map<Search, String> search) {
		this.search = search;
	}

	public List<Map<Order, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<Order, String>> order) {
		this.order = order;
	}

	public List<Map<Column, String>> getColumns() {
		return columns;
	}

	public void setColumns(List<Map<Column, String>> columns) {
		this.columns = columns;
	}

	public Map<String, Object> getReqParams() {
		return reqParams;
	}
	public void setReqParams(Map<String, Object> reqParams) {
		this.reqParams = reqParams;
	}


	
    
}
