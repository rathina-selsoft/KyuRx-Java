package com.selsoft.kyurx.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selsoft.kyurx.doctor.mapper.DoctorMapper;
import com.selsoft.kyurx.models.Doctor;
import com.selsoft.kyurx.models.UserRole;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorMapper doctorMapper;

	@Override
	public Doctor addNewDoctor(Doctor doctor) throws Throwable {
		UserRole userRole = new UserRole();
		userRole.setEmailId(doctor.getEmailId());
		userRole.setRole("DOCTOR");
		doctorMapper.insertUserRole(userRole);

		doctor.setRoleId(userRole.getUserRoleId());
		doctorMapper.insertDoctor(doctor);
		return doctor;
	}

}
