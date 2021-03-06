package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Buddy;

public interface BuddyRepository extends JpaRepository<Buddy, Long>{
	
	public List<Buddy> findByCompanyCity(String companyCity);
	
	public List<Buddy> findByCompanyName(String companyName);

}
