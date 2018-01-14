package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.SkuType;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("skuTypeDao")
public interface SkuTypeDao {


    int deleteByPrimaryKey(Integer skutypeid);

    int insert(SkuType record);

    int insertSelective(SkuType record);


    SkuType selectByPrimaryKey(Integer skutypeid);



    int updateByPrimaryKeySelective(SkuType record);

    int updateByPrimaryKey(SkuType record);

	List<SkuType> queryAllSkuType();
}