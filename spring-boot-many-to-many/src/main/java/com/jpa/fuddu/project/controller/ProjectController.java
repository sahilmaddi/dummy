package com.jpa.fuddu.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.fuddu.employee.entity.Employee;
import com.jpa.fuddu.project.entity.Project;
import com.jpa.fuddu.project.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/save")
	public ResponseEntity createProject(@RequestBody Project projectObj) {
		projectService.saveProject(projectObj);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping(value={"/getProjects","{projectId}"})
	public List<Project> getEmployee(@PathVariable(required = false)Long projectId){
		return projectService.getProjectDetails(projectId);
	}
	@DeleteMapping("delete/{empId}")
	public ResponseEntity removeEmployee(@PathVariable Long projectId) {
		projectService.deleteEmployee(projectId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
