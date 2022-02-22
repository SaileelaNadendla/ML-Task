package com.bhavna.model;


import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpId(rs.getInt("EMPID"));
		emp.setEname(rs.getString("ENAME"));
		emp.setEsal(rs.getDouble("ESAL"));
		emp.setDoj(rs.getString("DOJ"));
		emp.setDeptId(rs.getInt("DEPTID"));
		emp.setStatus(rs.getString("STATUS"));
		return emp;
	}
	

	
	
	
}
