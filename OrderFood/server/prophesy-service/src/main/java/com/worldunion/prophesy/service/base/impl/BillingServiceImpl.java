package com.worldunion.prophesy.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.BillingDao;
import com.worldunion.prophesy.model.sku.Billing;
import com.worldunion.prophesy.service.base.BillingService;
@Service(value = "billingService")
public class BillingServiceImpl implements BillingService {
	@Autowired
	BillingDao	billingDao;


	@Override
	public Billing selectBillingByid(Integer id) {
		return billingDao.selectBillingByid(id);
	}

	@Override
	public List<Billing> selectBillingList(Map<String, Object> params) {
		return billingDao.selectBillingList(params);
	}

	@Override
	public void updateBillingByParam(Map<String, Object> param) {
		billingDao.updateBillingByParam(param);
		
	}
	

	
}
