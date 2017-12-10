package com.worldunion.prophesy.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.SkuDao;
import com.worldunion.prophesy.dao.SkuTypeDao;
import com.worldunion.prophesy.model.sku.Sku;
import com.worldunion.prophesy.model.sku.SkuType;
import com.worldunion.prophesy.service.base.SkuService;
@Service(value = "skuService")
public class SkuServiceImpl implements SkuService {
	@Autowired
	SkuDao	skuDao;
	@Autowired
	SkuTypeDao	skuTypeDao;

	@Override
	public Sku selectSkuList(Integer skuid) {
		
		return skuDao.selectByPrimaryKey(skuid);
	}

	@Override
	public List<Sku> selectLimitSkuList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SkuType> queryAllSkuType() {
		return skuTypeDao.queryAllSkuType();
	}

	@Override
	public List<Sku> queryAllSkuList(Integer skuTypeId) {
		return skuDao.queryAllSkuList(skuTypeId);
	}
	

	
}
