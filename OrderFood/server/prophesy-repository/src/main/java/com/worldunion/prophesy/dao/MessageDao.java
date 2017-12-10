package com.worldunion.prophesy.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.worldunion.prophesy.model.sku.Message;
@Repository("messageDao")
public interface MessageDao {

    int deleteByPrimaryKey(Integer messageid);

    int insert(Message record);

    int insertSelective(Message record);


    Message selectByPrimaryKey(Integer messageid);



    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

	List<Message> queryUserMessageByParams(Map<String, Object> param);
}