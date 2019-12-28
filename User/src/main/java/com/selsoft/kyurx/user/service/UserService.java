package com.selsoft.kyurx.user.service;

import org.springframework.stereotype.Service;

import com.selsoft.kyurx.models.User;

@Service
public interface UserService {

	void addUserWithRole(User user, String activationUrl) throws Throwable;

}
