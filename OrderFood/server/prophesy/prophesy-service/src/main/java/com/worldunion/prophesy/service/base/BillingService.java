package com.worldunion.prophesy.service.base;

import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.sku.Billing;



public interface BillingService {
	
	public Billing selectBillingByid(Integer id);

	public List<Billing> selectBillingList(Map<String, Object> params);

	public void updateBillingByParam(Map<String, Object> param);

	public int insertBillInfo(Map<String, Object> param);   

	public void insertBillSkuInfo(List<Map<String, Object>> billskuling);
}
