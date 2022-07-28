package com.jpa.fuddu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.fuddu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
