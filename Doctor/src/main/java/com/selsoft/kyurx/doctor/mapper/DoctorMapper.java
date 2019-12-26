package com.selsoft.kyurx.doctor.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.selsoft.kyurx.models.Doctor;
import com.selsoft.kyurx.models.UserRole;

@Mapper
public interface DoctorMapper {

	void insertUserRole(UserRole userRole) throws Throwable;

	void insertDoctor(Doctor doctor) throws Throwable;

}
