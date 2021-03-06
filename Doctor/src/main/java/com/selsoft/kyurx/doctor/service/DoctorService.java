package com.selsoft.kyurx.doctor.service;

import org.springframework.stereotype.Service;

import com.selsoft.kyurx.models.User;

@Service
public interface DoctorService {

	void addUserWithRole(User user, String activationUrl) throws Throwable;

}
