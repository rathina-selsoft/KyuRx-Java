package com.selsoft.kyurx.doctor.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selsoft.kyurx.doctor.mapper.DoctorMapper;
import com.selsoft.kyurx.models.User;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorMapper doctorMapper;

	private static final Logger logger = Logger.getLogger(DoctorServiceImpl.class);

	@Override
	public void addUserWithRole(User user, String activationUrl) throws Throwable {
		
		

	}

}
