package com.jpa.fuddu.employee.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jpa.fuddu.employee.entity.Employee;
import com.jpa.fuddu.employee.repository.EmployeeRepository;
import com.jpa.fuddu.project.entity.Project;
import com.jpa.fuddu.project.repository.ProjectRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRep;
	@Autowired
	private ProjectRepository projectRep;
	
	public void saveEmployee(Employee empObj) {
		empRep.save(empObj);
		
	}

	public List<Employee> getEmployeeDetails(Long empId) {
		if(null != empId) {
			return empRep.findAllByEmpId(empId);
		}
		else {
			return empRep.findAll();
		}
	}

	public void deleteEmployee(Long empId) {
		empRep.deleteById(empId);
	}

	public Employee assignProjectToEmployee(Long empId, Long projectId) {
		Set<Project> projectSet = null;
		Employee employee = empRep.findById(empId).get();
		Project project =projectRep.findById(projectId).get() ;
		projectSet=employee.getAssignedProjects();
		projectSet.add(project);
		employee.setAssignedProjects(projectSet);
		return empRep.save
				 (employee);
	}

}
