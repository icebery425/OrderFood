package com.worldunion.prophesy.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.UserAddrDao;
import com.worldunion.prophesy.dao.UserDao;
import com.worldunion.prophesy.model.sku.UserAddr;
import com.worldunion.prophesy.service.base.UserAddrService;
import com.worldunion.prophesy.service.base.UserService;
@Service(value = "userAddrService")
public class UserAddrServiceImpl implements UserAddrService {
	@Autowired
	UserDao	userDao;
	@Autowired
	UserAddrDao	userAddrDao;
	@Override
	public List<UserAddr> queryUserAddrByParams(Map<String, Object> param) {
		return userAddrDao.queryUserAddrByParams(param);
	}

	
	

	
}
