package com.worldunion.prophesy.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldunion.prophesy.dao.UserDao;
import com.worldunion.prophesy.model.sku.User;
import com.worldunion.prophesy.service.base.LoginService;
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserDao	userDao;
	
	@Override
	public List<User> selectUserByParams(Map<String, Object> params) {
		return userDao.selectUserByParams(params);
		
	}

	@Override
	public int insertUserByParams(Map<String, Object> params) {
		return userDao.insertUserByParams(params);
	}

	
	

	
}
