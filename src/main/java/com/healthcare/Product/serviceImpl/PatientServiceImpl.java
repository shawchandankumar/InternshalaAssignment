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
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	public Patient createPatient(Patient patient) {
		patient.setPatientId(sequenceGeneratorService.generateSequence(Patient.SEQUENCE_NAME));
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		return patientRepo.findAll();
	}
	
	@Override
	public Patient getPatient(Integer id) {
		return patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "patiendId", id));
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public void deletePatient(Integer id) {
		Patient deletedPatient = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "patiendId", id));
		patientRepo.delete(deletedPatient);
	}

}
