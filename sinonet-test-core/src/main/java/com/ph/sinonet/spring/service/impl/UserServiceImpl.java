package com.ph.sinonet.spring.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph.sinonet.spring.dao.UserDao;
import com.ph.sinonet.spring.model.entity.User;
import com.ph.sinonet.spring.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public void save(User user) {
		dao.saveUser(user);		
	}

	@Override
	public void update(User user) {
		dao.updateUser(user);
	}

	
	@Override
	public void updateLastVisit(User user, String ip) {
		user.setLastLoginIp(ip);
		user.setLastLoginTime(DateTime.now().toDate());
		this.update(user);
	}
	
	
	@Override
	public User getUser(String username) {
		return dao.getUserByName(username);
	}
	
	
	
}
