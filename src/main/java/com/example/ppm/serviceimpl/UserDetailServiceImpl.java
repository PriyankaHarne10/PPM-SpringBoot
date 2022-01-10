package com.example.ppm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.ppm.model.MyUserDetails;
import com.example.ppm.model.User;
import com.example.ppm.repository.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new MyUserDetails(user);
	}

}
