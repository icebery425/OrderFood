package com.worldunion.prophesy.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.UserAddrDao;
import com.worldunion.prophesy.dao.UserDao;
import com.worldunion.prophesy.service.base.UserService;
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao	userDao;
	@Autowired
	UserAddrDao	userAddrDao;

	
	

	
}
