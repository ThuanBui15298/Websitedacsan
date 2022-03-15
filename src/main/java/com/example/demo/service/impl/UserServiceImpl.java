package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.api.AccountApi;
import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Roler;
import com.example.demo.entity.Users;
import com.example.demo.repository.RolerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolerRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	@Override
	public Users findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Users findByConfirmationToken(String confirmationToken) {
		return null;
	}

	@Override
	public Users saveUserForMember(Users user) {

		user.setPassword(passwordEncoder().encode(user.getPassword()));
		Set<Roler> setRoler = new HashSet<>();
		
		setRoler.add(roleRepository.findByNameRoler("ROLE_MEMBER"));
		user.setRoler(setRoler);
		return userRepository.save(user);
	}

	@Override
	public Users findById(long id) {
		Users user = userRepository.findById(id).get();
		return user;
	}

	@Override
	public Users updateUser(Users user) {
		return userRepository.save(user);
	}

	@Override
	public void changePass(Users user, String newPass) {
		user.setPassword(passwordEncoder().encode(newPass));
		userRepository.save(user);
	}

//	@Override
//	public List<Users> getUsersByRoler(Set<Roler> roler) {
//		return userRepository.findByRoler(roler);
//	}

	@Override
	public List<Users> getUsersByRoler (String rolerName) {
		return userRepository.findByRoler(rolerName);
	}

	@Override
	public Users saveUserForAdmin(AccountDTO dto) {
		Users users = new Users();
		users.setUserName(dto.getName());
		users.setAddress(dto.getAddress());
		users.setEmail(dto.getEmail());
		users.setPhone(dto.getPhone());
		users.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		
		Set<Roler> roler  = new HashSet<>();
		roler.add(roleRepository.findByNameRoler(dto.getNameRoler()));
		users.setRoler(roler);
		
		return userRepository.save(users);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}
	@Override
	public Users saveUserForAdmin(@Valid AccountApi acc) {
		// TODO Auto-generated method stub
		return null;
	}


}
