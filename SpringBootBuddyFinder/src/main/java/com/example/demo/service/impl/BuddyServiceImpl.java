package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Buddy;
import com.example.demo.repository.BuddyRepository;
import com.example.demo.service.BuddyService;

@Service
public class BuddyServiceImpl implements BuddyService {

	private BuddyRepository buddyRepository;

	@Autowired
	public BuddyServiceImpl(BuddyRepository buddyRepository) {
		super();
		this.buddyRepository = buddyRepository;
	}

	@Override
	public Buddy saveBuddy(Buddy buddy) {
		return buddyRepository.save(buddy);
	}

	@Override
	public List<Buddy> getAllBuddies() {
		return buddyRepository.findAll();
	}

	@Override
	public Buddy getBuddyById(long id) {
		return buddyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Buddy", "ID", String.valueOf(id)));
	}

	@Override
	public Buddy updateBuddy(Buddy buddy, long id) {
		Buddy existingBuddy = buddyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Buddy", "ID", String.valueOf(id)));

		existingBuddy.setFirstName(buddy.getFirstName());
		existingBuddy.setLastName(buddy.getLastName());
		existingBuddy.setEmail(buddy.getEmail());
		existingBuddy.setPhoneNumber(buddy.getPhoneNumber());
		existingBuddy.setCompanyCity(buddy.getCompanyCity());
		existingBuddy.setCompanyName(buddy.getCompanyName());
		existingBuddy.setCompanyAddress(buddy.getCompanyAddress());

		buddyRepository.save(existingBuddy);
		return existingBuddy;
	}

	@Override
	public void deleteBuddy(long id) {
		buddyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Buddy", "ID", String.valueOf(id)));

		buddyRepository.deleteById(id);

	}

	@Override
	public List<Buddy> getBuddiesByCompanyCity(String companyCity) {
		return buddyRepository.findByCompanyCity(companyCity);
	}

	@Override
	public List<Buddy> getBuddiesByCompanyName(String companyName) {
		return buddyRepository.findByCompanyName(companyName);
	}

}
