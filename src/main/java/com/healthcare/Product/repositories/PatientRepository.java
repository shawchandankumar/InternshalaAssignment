package com.healthcare.Product.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.healthcare.Product.models.Patient;

public interface PatientRepository extends MongoRepository<Patient, Integer> {

}
