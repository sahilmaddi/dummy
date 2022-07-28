package com.jpa.fuddu.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.fuddu.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findAllByEmpId(Long empId);
}
