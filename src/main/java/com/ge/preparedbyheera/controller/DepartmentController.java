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
import com.ge.preparedbyheera.model.Department;
import com.ge.preparedbyheera.repository.DepartmentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DepartmentController {

	@Autowired
	public DepartmentRepository departmentRepo;
	
	@GetMapping("/department")
	public List<Department> getAllDepartments(){
		return departmentRepo.findAll();
	}
	
	@PostMapping("/department")
	public Department createDepartment(@RequestBody Department dept){
		Department departmentObj=departmentRepo.save(dept);
		return departmentObj;
	}
	
	@DeleteMapping("/department/{id}")
	public void deletedepartment(@PathVariable long id) {
		departmentRepo.deleteById(id);
	}
	
	@PutMapping("/department/{id}")
	public ResponseEntity<Object> updatedepartment(@RequestBody Department department, @PathVariable long id){
		Optional<Department> Department=departmentRepo.findById(id);
		if(!Department.isPresent())
			return ResponseEntity.notFound().build();
		department.setId(id);
		departmentRepo.save(department);
		return ResponseEntity.noContent().build();		
	}

	
}
