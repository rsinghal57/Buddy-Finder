package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Buddy;
import com.example.demo.service.BuddyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/buddies")
public class BuddyController {
	
	private BuddyService buddyService;

	@Autowired
	public BuddyController(BuddyService buddyService) {
		super();
		this.buddyService = buddyService;
	}
	
	//create Buddy REST API
		@PostMapping
		public Buddy saveBuddy(@RequestBody Buddy buddy)
		{
			return buddyService.saveBuddy(buddy);
		}
		
		//Get all Buddies REST API
		@GetMapping
		public List<Buddy> getAllBuddies()
		{
			return buddyService.getAllBuddies();
		}
		
		
		//Get all buddies by city REST API
			@GetMapping("/searchbycity")
			public List<Buddy>getBuddiesByCompanyCity(@RequestParam(name="city") String city)
			{
				return buddyService.getBuddiesByCompanyCity(city);
			}
			
			//Get all buddies by company name REST API
			@GetMapping("/searchbycompany")
			public List<Buddy>getBuddiesByCompanyName(@RequestParam(name="company") String company)
			{
				return buddyService.getBuddiesByCompanyName(company);
			}
		
		
		
		//Get Buddy by Id REST API
		@GetMapping("{id}")
		public ResponseEntity<Buddy> getBuddyById(@PathVariable(name = "id") long id)
		{
			return new ResponseEntity<Buddy>(buddyService.getBuddyById(id), HttpStatus.OK);
		}
		
		
		//update Buddy REST API
		@PutMapping("{id}")
		public ResponseEntity<Buddy> updateBuddy(@RequestBody Buddy buddy, @PathVariable(name = "id") long id)
		{
			return new ResponseEntity<Buddy>(buddyService.updateBuddy(buddy, id),HttpStatus.OK);
		}
		
		//delete Buddy REST API
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteBuddy(@PathVariable(name = "id") long id)
		{
			buddyService.deleteBuddy(id);
			return new ResponseEntity<String>("Record Deleted Successfully",HttpStatus.OK);
		}
		
	
	
	

}
