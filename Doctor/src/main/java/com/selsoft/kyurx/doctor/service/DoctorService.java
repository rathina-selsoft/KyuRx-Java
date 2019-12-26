package com.selsoft.kyurx.doctor.service;

import org.springframework.stereotype.Service;

import com.selsoft.kyurx.models.Doctor;

@Service
public interface DoctorService {

	Doctor addNewDoctor(Doctor doctor) throws Throwable;

}
