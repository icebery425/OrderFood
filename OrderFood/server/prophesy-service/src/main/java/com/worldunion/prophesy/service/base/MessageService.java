package com.worldunion.prophesy.service.base;

import java.util.List;
import java.util.Map;

import com.worldunion.prophesy.model.sku.Message;



public interface MessageService {

	List<Message> queryUserMessageByParams(Map<String, Object> param);
	
	
}
