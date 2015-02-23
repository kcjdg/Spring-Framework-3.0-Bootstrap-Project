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

import com.ph.sinonet.spring.model.entity.User;
import com.ph.sinonet.spring.service.interfaces.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{


	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User r = userService.getUser(username);
		System.out.println(r);
		
		if(r == null){
			throw new UsernameNotFoundException("No such username :" + username);
		}

	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;
	    
	    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
	    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	    
	    return new org.springframework.security.core.userdetails.User(username, r.getPassword(),authList);
	}

	
}
