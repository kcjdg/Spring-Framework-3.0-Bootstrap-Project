package com.ph.sinonet.spring.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ph.sinonet.spring.model.entity.User;


@Repository
public class TestDao {
	
	private GenericDao<User> userDao;

	@Autowired
	public void setUserDao(GenericDao<User> userDao) {
		this.userDao = userDao;
		userDao.setClazz(User.class);
	}
	
	public void saveUser(User user) {
		userDao.save(user);
	}
	
	public void updateUser(User user){
		userDao.update(user);
	}

	public User getUserWithLockMode(String username, LockOptions options){
		return userDao.findById(username, options);
	}
	
	public User getUserByName(String username){
		return userDao.findById(username);
	}
	
	public List<User> getAllUser(){
		return userDao.findAll();
	}
	
}
