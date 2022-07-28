package com.jpa.fuddu.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.fuddu.employee.entity.Employee;
import com.jpa.fuddu.project.entity.Project;
import com.jpa.fuddu.project.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRep;

	public void saveProject(Project projectObj) {
		projectRep.save(projectObj);
		
	}

	public List<Project> getProjectDetails(Long projectId) {
		if(null != projectId) {
			return projectRep.findAllByProjectId(projectId);
		}
		else {
			return projectRep.findAll();
		}
	}

	public void deleteEmployee(Long projectId) {
		
		
	}

}
