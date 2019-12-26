package com.selsoft.kyurx.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selsoft.kyurx.doctor.mapper.DoctorMapper;


@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorMapper doctorMapper;

}
