package com.ph.sinonet.spring.service.interfaces;

import com.ph.sinonet.spring.model.entity.User;


public interface UserService {
	
	public void save(User user);
	
	public void update(User user);
	
	public void updateLastVisit(User user, String ip);
	
	public User getUser(String username);
	
	
}
