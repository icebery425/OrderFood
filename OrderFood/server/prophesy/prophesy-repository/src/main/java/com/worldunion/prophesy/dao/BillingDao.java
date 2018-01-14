package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.Billing;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("billingDao")
public interface BillingDao {
   

    int deleteByPrimaryKey(Integer billid);

    int insert(Billing record);

    int insertSelective(Billing record);


    Billing selectByPrimaryKey(Integer billid);

   

    int updateByPrimaryKeySelective(Billing record);

    int updateByPrimaryKey(Billing record);

	Billing selectBillingByid(Integer id);

	List<Billing> selectBillingList(Map<String, Object> params);

	void updateBillingByParam(Map<String, Object> param);

	int insertBillingInfo(Map<String, Object> param);

	void insertBillSkuInfo(List<Map<String, Object>> billskuling);
}