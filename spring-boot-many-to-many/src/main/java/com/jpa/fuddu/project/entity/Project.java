package com.jpa.fuddu.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.fuddu.employee.entity.Employee;

import lombok.Data;

@Entity
@Data
@Table(name="PROJECT")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;
	private String projectName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "assignedProjects")
	private Set<Employee> employeeSet = new HashSet<>();

}
