package com.healthcare.Product.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long patientId;
	private String patientname;
	private String patientContactNo;

}
