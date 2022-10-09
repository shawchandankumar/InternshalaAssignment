package com.healthcare.Product.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.Product.exception.ResourceNotFoundException;
import com.healthcare.Product.models.Patient;
import com.healthcare.Product.repositories.PatientRepository;
import com.healthcare.Product.services.PatientService;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		return patientRepo.findAll();
	}
	
	@Override
	public Patient getPatient(int id) {
		return patientRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Patient", "patient id", id));
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public void deletePatient(int id) {
		patientRepo.deleteById(id);
	}

}
