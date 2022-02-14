/*
 * Create Employee,Department tables in DB,
 *  Should create the relations PrimaryKey ,foreign key with these tables and make sure use data types like bigint,varchar,date/datetime.
 *   1.fetch the data emplyeeid,employee name,employee sal,joining date of emp ,deptid, dept name using jdbc
 *   2.save employee and department tables using jdbc 
 *   3.updating the employee table using jdbc
     4. write a query for find the number of employees in each department whose employee sal greater than 30000.(fetch coulms dept name,count of emplyee)
     */



package com.bhavna.Employee_tbl;

import java.util.Scanner;

import com.bhavna.Jdbc.EmployeeJdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    {
    	EmployeeJdbc emp = new EmployeeJdbc();
    	
          EmployeeJdbc.connectionToDB();
           char ch = 'Y';
           Scanner sc = new Scanner(System.in);
           do {
        	   System.out.println("Select opition");
        	   System.out.println("1.Do you want to add Department record");
        	   System.out.println("2.Do you want to add Employee record");
        	   System.out.println("3.Update record");
        	   System.out.println("4.COUNT");
        	   System.out.println("5.Fetching Records");
        	   System.out.println("6.Fetching Records from DepartmentS");

        	   
        	   
        	   int choice = sc.nextInt();
        	   sc.nextLine();
        	   switch (choice) {
        	  
         	   case 1:
        		   System.out.println("Department :");
        		   emp.insertDepartment();
        		   
        		   break;
        	   case 2:
        		   System.out.println("Employee:");
        		   emp.insertEmployee();
        		   
        		   break;
        	   case 3:
        		   System.out.println("UPDATEDEPT:");
        		   emp.updateDpt();
        		   
        		   break;
        	   case 4:
        		   System.out.println("COUNT:");
        		   emp.count();
        		   
        		   break;
        		   
        	   case 5:
        		   System.out.println("FETCHING RECORDS:");
        		   emp.fetchingData();
        		   
        		   break;
        		   
        	   case 6:
        		   System.out.println("FETCHING RECORDS:");
        		   emp.fetchingdept();
        		   
        		   break;
        		   
        		   
        		
        		default:
				System.out.println("Invalid option please enter valid option");
        	   }
           
			
		} while (ch == 'Y' || ch == 'y');
           sc.close();
    }
    
    
    } 	
}


