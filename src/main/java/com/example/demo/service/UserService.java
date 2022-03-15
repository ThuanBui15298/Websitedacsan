package com.example.demo.service;

import java.util.List;
import javax.validation.Valid;
import com.example.demo.api.AccountApi;
import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Users;

public interface UserService {

	
	Users findByEmail(String email);

	Users findByConfirmationToken(String confirmationToken);

	Users findById(long id);

	Users updateUser(Users user);

	void changePass(Users user, String newPass);

	//List<Users> getUsersByRoler(Set<Roler> roler);
	
	Users saveUserForAdmin(@Valid AccountApi acc);

	void deleteById(long id);

	List<Users> getUsersByRoler(String rolerName);

	Users saveUserForMember(Users user);

	Users saveUserForAdmin(AccountDTO dto);

}
