package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
private String id;
	
	@NotEmpty(message="Phải nhập địa chỉ email")
	@Email(message= "Phải nhập đúng địa chỉ email")
	private String email;

	@Length(min=8, max=32, message="mật khẩu phải dài 8-32 ký tự")
	private String password;
	
	private String confirmPassword;
	
	@NotEmpty(message="Địa chỉ không được trống")
	private String address;
	
	@NotEmpty(message="Họ tên không được trống")
	private String name;
	
	@NotEmpty(message="Số điện thoại không được trống")
	
	private String phone;
	
	private String nameRoler;
}
