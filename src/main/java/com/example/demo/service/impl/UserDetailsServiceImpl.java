package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Roler;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users users = userRepository.findByEmail(username);
		if (users == null) {
			throw new UsernameNotFoundException("User with email " + username + " was not be found");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Set<Roler> rolers = users.getRoler();
		for (Roler roler : rolers) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roler.getNameRoler()));
		}
		return new User(username, users.getPassword(), grantedAuthorities);
	}

}
