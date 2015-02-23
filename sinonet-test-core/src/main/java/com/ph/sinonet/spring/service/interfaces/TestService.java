package com.ph.sinonet.spring.service.interfaces;

import java.util.List;

import org.hibernate.LockOptions;

import com.ph.sinonet.spring.model.entity.User;

public interface TestService {

	public void saveUser(User user);

	public void update(User user);

	public User getEntityWithLockMode(String id, LockOptions options);
	
	public User getUser(String username);

	public List<User> getAllUsers();


}
