package com.bhavna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavna.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
