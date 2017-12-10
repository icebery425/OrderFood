package com.worldunion.prophesy.dao;

import com.worldunion.prophesy.model.sku.UserAddr;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository("userAddrDao")
public interface UserAddrDao {


    int deleteByPrimaryKey(Integer useraddrid);

    int insert(UserAddr record);

    int insertSelective(UserAddr record);


    UserAddr selectByPrimaryKey(Integer useraddrid);



    int updateByPrimaryKeySelective(UserAddr record);

    int updateByPrimaryKey(UserAddr record);

	List<UserAddr> queryUserAddrByParams(Map<String, Object> param);
}