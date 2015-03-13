package com.ph.sinonet.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.ph.sinonet.spring.enums.FlagType;
import com.ph.sinonet.spring.model.entity.User;
import com.ph.sinonet.spring.service.interfaces.UserService;
import com.ph.sinonet.spring.util.HibernatePBEStringEncryptor;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{


	@Autowired
	private UserService userService;

	@Autowired
	private HibernatePBEStringEncryptor encryptor;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		
		
		User user = userService.getUser(username);
	
		if(user == null){
			throw new UsernameNotFoundException("No such username :" + username);
		}
		
		//encrypt password
		String decryptedPassword = encryptor.manualDecrypt(user.getPassword());
		user.setPassword(decryptedPassword);
			
		
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = FlagType.getBool(user.getFlag().getType());
	    
	    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
	    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	    
	    return new org.springframework.security.core.userdetails.User(username, user.getPassword(),authList);
	}
	
}
