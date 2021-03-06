package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Buddy;

public interface BuddyService {
	
    public Buddy saveBuddy(Buddy buddy);
	
	public List<Buddy> getAllBuddies();
	
	public Buddy getBuddyById(long id);
	
	public Buddy updateBuddy(Buddy buddy, long id);
	
	public void deleteBuddy(long id);
	
	
	public List<Buddy> getBuddiesByCompanyCity(String companyCity);
	
	public List<Buddy> getBuddiesByCompanyName(String companyName);

}
