package com.cognizant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.entity.User;
import com.cognizant.repo.userRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	userRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user1 = this.repo.findByEmail(username);
		if(user1==null) {
			throw new UsernameNotFoundException("User Not Found With UserName : "+username);
		}
		return new UserDetailsImpl(user1);
	}

}
