package com.worldunion.prophesy.model;

import java.io.Serializable;


/**
 * 实体基类(ID的类型可能为String/Integer)
 *
 */
public class IdEntity<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private T id;
	
	public IdEntity()
	{
		
	}
	
	public IdEntity(T id)
	{
		this.id=id;
	}
	
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = (T) id;
	}
	
	public int compareTo(IdEntity<T> o) {
		return 0;
	}
	
     public  void setUUID()
     {
    	// if(this.id==null||com.shihua.common.util.StringUtil.isEmpty(this.id+""))
    	// this.setId((T) (UUID.randomUUID()+"").replaceAll("-",""));
     }
     
     
}
