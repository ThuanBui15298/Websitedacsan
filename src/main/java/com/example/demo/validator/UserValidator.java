package com.example.demo.validator;

import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@Service
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Users user = (Users) target;

		ValidationUtils.rejectIfEmpty(errors, "email", "error.email", "Họ tên không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "phone", "error.phone", "Số điện thoại không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.address", "Địa chỉ không được bỏ trống");

		// validate cho email
		// check ko đc trống
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email", "Email không được trống");

		// check địa chỉ email phù hợp hay không
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		if (!(pattern.matcher(user.getEmail()).matches())) {
			errors.rejectValue("email", "error.email", "Địa chỉ email không phù hợp");
		}

		// check địa chi email đã được dùng chưa
		if (userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "error.email", "Địa chỉ email đã được sử dụng");
		}

		// check password trống hay không
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password không được bỏ trống");

		// check confirmPassword trống hay không
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.confirmPassword",
				"Nhắc lại mật khẩu không được bỏ trống");

		// check độ dài password (8-32)
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "error.password", "Mật khẩu phải dài 8-32 ký tự");
		}

		// check match pass và confirmPass
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			errors.rejectValue("confirmPassword", "error.confirmPassword", "Nhắc lại mật khẩu không chính xác");
		}
	}
}
