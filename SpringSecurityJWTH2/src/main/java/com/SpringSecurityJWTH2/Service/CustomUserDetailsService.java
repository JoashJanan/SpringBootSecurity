package com.SpringSecurityJWTH2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurityJWTH2.Entity.AppUser;
import com.SpringSecurityJWTH2.Repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	 	@Autowired
	    private UserRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {

	    	AppUser user = repository.findByUsername(username)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	        return org.springframework.security.core.userdetails.User
	                .withUsername(user.getUsername())
	                .password(user.getPassword())
	                .roles(user.getRole().name())
	                .build();
	    }
}
