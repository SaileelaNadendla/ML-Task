package com.bhavna.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.model.Employee;
@Repository
public interface EmployeeRep extends CrudRepository<Employee, Integer> {
	@Query(value="select * from EMP where status ='active'", nativeQuery = true)
	Collection<Employee>getAllActiveEmployees();
}
