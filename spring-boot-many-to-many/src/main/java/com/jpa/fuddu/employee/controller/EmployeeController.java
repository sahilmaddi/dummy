package com.jpa.fuddu.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.fuddu.employee.entity.Employee;
import com.jpa.fuddu.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee empObj){
		empService.saveEmployee(empObj);
		return new ResponseEntity<Employee>(HttpStatus.CREATED);
	}
	@GetMapping(value={"/getEmployees","{empId}"})
	public List<Employee> getEmployee(@PathVariable(required = false)Long empId){
		return empService.getEmployeeDetails(empId);
	}
	@DeleteMapping("delete/{empId}")
	public ResponseEntity removeEmployee(@PathVariable Long empId) {
		empService.deleteEmployee(empId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/{empId}/project/{projectId}")
	public Employee assignProjectToEmployee(
			@PathVariable Long empId,
			@PathVariable Long projectId
			) {
		return empService.assignProjectToEmployee(empId,projectId);
		
	}
}
