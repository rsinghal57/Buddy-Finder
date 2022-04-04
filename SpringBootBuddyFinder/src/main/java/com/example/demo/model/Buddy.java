package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "buddies")
public class Buddy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="first_name",nullable = false)
	private String firstName;
	
	@Column(name ="last_name",nullable = false)
	private String lastName;
	
	@Column(name ="email",nullable = false)
	private String email;
	
	@Column(name ="phone_number",nullable = false)
	private String phoneNumber;
	
	@Column(name ="company_city",nullable = false)
	private String companyCity;
	
	@Column(name ="company_name",nullable = false)
	private String companyName;
		
	@Column(name ="company_address",nullable = false)
	private String companyAddress;
	
	
	
}
