package com.worldunion.prophesy.model;

import java.io.Serializable;
import java.util.UUID;

/**
 基础实体
 */
public class Entity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T id;
	public Entity(T id){
		this.id=id;
	}
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = (T) id;
	}
	public int compareTo(Entity<T> o) {
		return 0;
	}
	public  void setUUID(){
    	 this.setId((T) (UUID.randomUUID().toString()));
    }
	public boolean equals(Entity<T> obj) {
		return super.equals(obj);
	}
}
