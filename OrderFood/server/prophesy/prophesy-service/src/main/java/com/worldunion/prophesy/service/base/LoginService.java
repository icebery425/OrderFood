package com.worldunion.prophesy.service.base;

import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.sku.Sku;
import com.worldunion.prophesy.model.sku.SkuType;
import com.worldunion.prophesy.model.sku.User;



public interface LoginService { 
	
	public List<User> selectUserByParams(Map<String, Object> params);

	public int insertUserByParams(Map<String, Object> params);
}
