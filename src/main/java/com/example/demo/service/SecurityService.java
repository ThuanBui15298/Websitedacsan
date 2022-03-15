package com.example.demo.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String email, String password);

}
