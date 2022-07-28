package com.jpa.fuddu.employee.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.jpa.fuddu.project.entity.Project;

import lombok.Data;
@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	private String empName;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="employee_project"
	,joinColumns = @JoinColumn(name="employee_id")
	,inverseJoinColumns = @JoinColumn(name="project_id")
	)
	private Set<Project> assignedProjects = new HashSet<>();
	

}
