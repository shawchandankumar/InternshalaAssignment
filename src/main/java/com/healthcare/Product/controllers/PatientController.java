package com.healthcare.Product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.Product.models.Patient;
import com.healthcare.Product.services.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = patientService.getAllPatient();
		return ResponseEntity.ok(patients);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> dummyController() {
		return ResponseEntity.ok("Yeah!! Its Working");
	}
	
	@GetMapping("/{patientid}")
	public ResponseEntity<Patient> getPatient(@PathVariable("patientid") Integer patientid) {
		Patient patient = patientService.getPatient(patientid);
		return new ResponseEntity<>(patient, HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient newPatient = patientService.createPatient(patient);
		return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		Patient updatedPatient = patientService.updatePatient(patient);
		return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
	}
	
	@DeleteMapping("/{patientid}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("patientid") Integer patientid) {
		Patient deletedPatient = patientService.getPatient(patientid);
		patientService.deletePatient(patientid);
		return new ResponseEntity<>(deletedPatient, HttpStatus.OK);
	}

}
