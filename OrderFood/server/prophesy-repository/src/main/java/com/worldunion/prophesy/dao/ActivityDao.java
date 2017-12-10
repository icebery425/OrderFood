package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.Activity;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("activityDao")
public interface ActivityDao {
   

    int deleteByPrimaryKey(Integer activityid);

    int insert(Activity record);

    int insertSelective(Activity record);


    Activity selectByPrimaryKey(Integer activityid);



    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}