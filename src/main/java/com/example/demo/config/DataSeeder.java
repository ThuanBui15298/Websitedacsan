package com.example.demo.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Roler;
import com.example.demo.entity.Users;
import com.example.demo.repository.RolerRepository;
import com.example.demo.repository.UserRepository;

@Component
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolerRepository roleRepository;

	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// vai tro
		Roler roler = new Roler();
		if (roleRepository.findByNameRoler("ROLE_ADMIN") == null) {
			roler.setNameRoler("ROLE_ADMIN");
			roleRepository.save(roler);
		}
		if (roleRepository.findByNameRoler("ROLE_MEMBER") == null) {
			roler.setNameRoler("ROLE_MEMBER");
			roleRepository.save(roler);
		}

		if (roleRepository.findByNameRoler("ROLE_SHIPPER") == null) {
			roler.setNameRoler("ROLE_SHIPPER");
			roleRepository.save(roler);
		}

		// Admin account
		if (userRepository.findByEmail("admin@gmail.com") == null) {
			Users admin = new Users();
			admin.setEmail("admin@gmail.com");
			admin.setPassword(passwordEncoder().encode("123456"));
			admin.setUserName("ThuanBui");
			admin.setPhone("123456789");
			HashSet<Roler> rolers = new HashSet<>();
			rolers.add(roleRepository.findByNameRoler("ROLE_ADMIN"));
			rolers.add(roleRepository.findByNameRoler("ROLE_MEMBER"));
			admin.setRoler(rolers);
			userRepository.save(admin);
		}

		// Member account
		if (userRepository.findByEmail("member@gmail.com") == null) {
			Users member = new Users();
			member.setEmail("member@gmail.com");
			member.setPassword(passwordEncoder().encode("123456"));
			HashSet<Roler> rolers = new HashSet<>();
			rolers.add(roleRepository.findByNameRoler("ROLE_MEMBER"));
			member.setRoler(rolers);
			userRepository.save(member);
		}

		// Shipper account
		if (userRepository.findByEmail("shipper@gmail.com") == null) {
			Users member = new Users();
			member.setEmail("shipper@gmail.com");
			member.setPassword(passwordEncoder().encode("123456"));
			HashSet<Roler> roles = new HashSet<>();
			roles.add(roleRepository.findByNameRoler("ROLE_SHIPPER"));
			member.setRoler(roles);
			userRepository.save(member);
		}
	}
}
