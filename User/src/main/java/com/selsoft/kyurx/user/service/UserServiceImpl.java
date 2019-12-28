package com.selsoft.kyurx.user.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selsoft.kyurx.constants.UserConstant;
import com.selsoft.kyurx.exception.KyuRxException;
import com.selsoft.kyurx.models.User;
import com.selsoft.kyurx.user.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void addUserWithRole(User user, String activationUrl) throws Throwable {

		if (StringUtils.isBlank(user.getEmailId())) {
			throw new KyuRxException("Validation Error", "User EmailId empty");
		}

		if (StringUtils.isBlank(user.getUserRole())) {
			throw new KyuRxException("Validation Error", "User Role empty");
		}

		validateUserRole(user.getUserRole());
		validateUserEmail(user, false);
		
		userMapper.insertUserWithRole(user);
	}

	private void validateUserEmail(User user, boolean isVerifyPassword) throws Throwable{

		if (emailValidation(user.getEmailId()) != null) {
			throw new KyuRxException("Duplicate Entry", "Another user has registered the same email id " + user.getEmailId()
					+ ", please register with a new email id");
		}
		if (isVerifyPassword)
			passwordValidation(user.getPassword());
		
	}

	private void passwordValidation(String password) throws Throwable{
		logger.info("Validating user password");
		if (StringUtils.isBlank(password)) {
			throw new KyuRxException("Password Validation Error", "Password missing, cannot create the User.");
		} else if (password.length() > 20 || password.length() < 8) {
			throw new KyuRxException("Password Validation Error",
					"Password should be at least 8 characters and below 20 characters in length.");
		}
		
	}

	// Email Address Validation
	private User emailValidation(String email) throws Throwable {
		logger.info("Validating user email");
		if (StringUtils.isBlank(email) || !email.matches(EMAIL_PATTERN)) {
			throw new KyuRxException("Validation Error", "Email is not Valid");
		}
		return userMapper.findUserByEmail(email);
	}

	private void validateUserRole(String userRole) throws Throwable {
		boolean found = false;
		for (UserConstant.USER_ROLE userTypeFromEnum : UserConstant.USER_ROLE.values()) {
			if (StringUtils.equals(userTypeFromEnum.getUserRoleValue(), userRole)) {
				found = true;
				break;
			}
		}

		if (!found) {
			throw new KyuRxException("Validation Error", "User role not found, please send a valid user role");
		}
	}

}
