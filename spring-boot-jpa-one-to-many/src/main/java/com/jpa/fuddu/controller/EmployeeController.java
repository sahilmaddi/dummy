package com.jpa.fuddu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.fuddu.entity.Employee;
import com.jpa.fuddu.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository empRep;
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<String> saveEmployee(@RequestBody List<Employee> empData){
		empRep.saveAll(empData);
		return ResponseEntity.ok("Data saved");
	}
}
