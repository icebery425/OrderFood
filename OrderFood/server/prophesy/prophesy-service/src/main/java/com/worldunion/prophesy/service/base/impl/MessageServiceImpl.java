package com.worldunion.prophesy.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.MessageDao;
import com.worldunion.prophesy.model.sku.Message;
import com.worldunion.prophesy.model.sku.UserAddr;
import com.worldunion.prophesy.service.base.MessageService;
@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDao	messageDao;

	@Override
	public List<Message> queryUserMessageByParams(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return messageDao.queryUserMessageByParams(param);
	}
	

	
	

	
}
