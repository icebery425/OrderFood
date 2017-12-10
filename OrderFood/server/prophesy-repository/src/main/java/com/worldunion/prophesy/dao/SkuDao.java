package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.Sku;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("skuDao")
public interface SkuDao {
    
    int deleteByPrimaryKey(Integer skuid);

    int insert(Sku record);

    int insertSelective(Sku record);

   

    Sku selectByPrimaryKey(Integer skuid);

   
    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

	List<Sku> queryAllSkuList(Integer skuTypeId);
}