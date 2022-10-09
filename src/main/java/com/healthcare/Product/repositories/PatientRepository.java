package com.healthcare.Product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.Product.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
