package com.ph.sinonet.spring.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ph.sinonet.spring.model.entity.User;


@Repository
public class TestDao extends GenericDao<User>{

	public void saveUser(User user) {
		save(user);
	}
	
	public void updateUser(User user){
		update(user);
	}

	public User getUserWithLockMode(String username, LockOptions options){
		return findById(username, options);
	}
	
	
	public User getUserByName(String username){
		return findById(username);
	}
	
	public List<User> getAllUser(){
		return findAll();
	}
	
}
