package com.ge.preparedbyheera.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.preparedbyheera.model.Employee;
import com.ge.preparedbyheera.model.Phone;
import com.ge.preparedbyheera.repository.PhoneRepository;

@RestController
public class PhoneController {

	@Autowired
	public PhoneRepository phoneRepo;
	
	@GetMapping("/phone")
	public List<Phone> getAllPhone(){
		return phoneRepo.findAll();
	}
	
	@PostMapping("/phone")
	public Phone createDepartment(@RequestBody Phone phone){
		Phone phoneObj=phoneRepo.save(phone);
		return phoneObj;
	}
	
	@DeleteMapping("/phone/{id}")
	public void deletePhone(@PathVariable long id) {
		phoneRepo.deleteById(id);
	}
	
	@PutMapping("/phone/{id}")
	public ResponseEntity<Object> updatePhone(@RequestBody Phone phone, @PathVariable long id){
		Optional<Phone> Phone=phoneRepo.findById(id);
		if(!Phone.isPresent())
			return ResponseEntity.notFound().build();
		phone.setId(id);
		phoneRepo.save(phone);
		return ResponseEntity.noContent().build();		
	}


}