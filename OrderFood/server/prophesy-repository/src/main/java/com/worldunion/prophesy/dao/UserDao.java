package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public interface UserDao {


    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer userid);



    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}