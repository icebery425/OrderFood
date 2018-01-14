package com.worldunion.prophesy.service.base;

import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.sku.Sku;
import com.worldunion.prophesy.model.sku.SkuType;



public interface SkuService { 
	
	public Sku selectSkuList(Integer skuid);

	public List<Sku> selectLimitSkuList(Map<String, Object> params);

	public List<SkuType> queryAllSkuType();

	public List<Sku> queryAllSkuList(Integer skuTypeId);
}
