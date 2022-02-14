package com.bhavna.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeJdbc {
	static Connection connection;
	public static void connectionToDB(){

	String dbUrl ="jdbc:sqlserver://localhost\\\\BHAVNAWKS774;databaseName=saiDB;portNumber=1433";
	String UserName = "sa";
	String Password = "Bhavna@123";
	try {

		connection = DriverManager.getConnection(dbUrl, UserName, Password);
		if(connection != null) {
			System.out.println("Connection Estableshed");
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
		
	}
	}
	
	static void close() {
			try {
				if(connection != null)
				{
					connection.close();
					System.out.println("Connection closed");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public static void departmentCreation() {
		try{
				Statement st=connection.createStatement();
				String deptCreation="CREATE TABLE DEPARTMENT(DEPTID BIGINT PRIMARY KEY,DEPTNAME VARCHAR(50))";
				// String query1="DROP TABLE DEPT";
				st.execute(deptCreation);
				System.out.println("Department Table Created Successfully: ");
				
				}catch(SQLException e) {
				e.printStackTrace();
				}
	}
	
	public static void employeeCreation() {
		try {
				Statement st=connection.createStatement();
				String empCreation="CREATE TABLE EMP(EMPID BIGINT,ENAME VARCHAR(50),ESAL MONEY, DOJ DATE,DEPTID BIGINT FOREIGN KEY REFERENCES DEPARTMENT(DEPTID))";
				// String query2="DROP TABLE EMP";
				st.execute(empCreation);
				System.out.println("Employee Table Created Successfully: ");
				
				}catch(SQLException e) {
				e.printStackTrace();
				}
	}
	public static void insertEmployee() {
		try {
			Statement st = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter EmpId:");
			int empId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter EmpName:");
			String empName = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Salary");
			int salary = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Joining Date:");
			String date = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter DeptID:");
			int deptId = sc.nextInt();
			sc.nextLine();
			String insertQuery="INSERT INTO EMP VALUES("+empId+",\'"+empName+"\',"+salary+",\'"+date+"\',"+deptId+")";
			st.executeUpdate(insertQuery);
			System.out.println("Record Inserted successfully");
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		}
	 public static void insertDepartment() {
		 try {
			Statement st = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter deptId: ");
			int deptId=sc.nextInt(); sc.nextLine();
			System.out.print("Enter deptName: ");
			String deptName=sc.nextLine();

			String insertQuery="INSERT INTO DEPARTMENT VALUES("+deptId+",\'"+deptName+"\')";
			st.executeUpdate(insertQuery);
			System.out.println("Record was inserted successfully! ");

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
			
	}
	 public static void updateDpt() {
		 try {
			 Statement st = connection.createStatement();
			 String updateQuery="UPDATE DEPARTMENT SET deptName=\'Marketing\' WHERE deptId=20";
			 st.executeUpdate(updateQuery);
			 System.out.println("ONE RECORD IS UPDATED! ");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	  public static void count() {
			 try {
				Statement st = connection.createStatement();
				String query="select deptName,count(*) as num from DEPARTMENT d inner join EMP e on e.DEPTID=d.DEPTID where ESAL>=20000 group by DEPTNAME";
				ResultSet rs=st.executeQuery(query);
				while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));
				}
				System.out.println("Executed Successfully: ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		  
	  }
	  public static void fetchingData() {
			try {
				Statement st = connection.createStatement();
				Scanner sc = new Scanner(System.in);
				System.out.println("Create select Query to Fetch the Data from Employee Table: ");
				String fetchingEmpQuery=sc.nextLine(); //Creating Select Query
				ResultSet rs=st.executeQuery(fetchingEmpQuery); //Executing Select the Query
				System.out.println("EMPID\tEMPNAME\tEMPSAL\t\tDOJ\t\tDEPTID");
				System.out.println("===========================================================");
				while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				}
				 
			
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

	  }
	  public static void fetchingdept() {
		  try {
			Statement st = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Create select Query to Fetch the Data from Department Table: ");
			
			String fetchingDeptDataQuery=sc.nextLine();		//Creating Select Query
			System.out.println("Dpeartment Table Created Successfully: ");
			ResultSet rs=st.executeQuery(fetchingDeptDataQuery);			//Executing Select the Query
			System.out.println("DEPTID\t"+"DEPTNAME\t");
			System.out.println("=========================");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		  
	  }
	 
	}

	
	
	
	
	


