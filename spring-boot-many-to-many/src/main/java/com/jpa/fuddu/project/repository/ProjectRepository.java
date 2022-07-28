package com.jpa.fuddu.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.fuddu.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	List<Project> findAllByProjectId(Long projectId);

}
