package com.healthcare.Product.services;

import java.util.List;

import com.healthcare.Product.models.Patient;

public interface PatientService {
	
	Patient createPatient(Patient patient);
	List<Patient> getAllPatient();
	Patient getPatient(Integer id);
	Patient updatePatient(Patient patient);
	void deletePatient(Integer id);

}
