package com.worldunion.prophesy.service.base;

import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.sku.Sku;
import com.worldunion.prophesy.model.sku.SkuType;
import com.worldunion.prophesy.model.sku.UserAddr;



public interface UserAddrService {

	List<UserAddr> queryUserAddrByParams(Map<String, Object> param);
	
	
}
