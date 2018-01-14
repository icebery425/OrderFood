package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.User;
import java.util.List;
import java.util.Map;

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

	List<User> selectUserByParams(Map<String, Object> params);

	int insertUserByParams(Map<String, Object> params);
}