/*
Create List of Employees. Employee Class Will have Name, Salary & Location fields.



*.Using Streams find the employee count whose name starts with ""S""
*.Using Parallel Stream Print all the Employees with location ""Hyderabad""
*.Get Location and employees in that location output : Map<String, List<Employees>> ex : key : "Hyderbad" value : Employees who reside in Hyderabad
*.Using Streams Check if any Employee's Salary is > 100000
* Using Lambds's Write a logic to sort EmployeeList based on Name & location
*/
package com.bhavna.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.stream.Collectors;

public class EmployeeService {
	static List<Employee> list;

	public static void main(String[] args) {

	}

	public static void getAll() {
		list = new ArrayList<Employee>();
		list.add(new Employee("Karnthi", 50000d, "Hyderabad"));
		list.add(new Employee("Anish", 60000d, "Delhi"));
		list.add(new Employee("Sai", 30000d, "Guntur"));
		list.add(new Employee("Anusha", 45000d, "Hyderabad"));
		list.add(new Employee("Swathi", 50000d, "Noida"));
		list.add(new Employee("Niraj", 100000d, "Orangle"));
		list.add(new Employee("Amith", 70000d, "Guntur"));
		list.add(new Employee("Pooja", 40000d, "Hyderabad"));

		System.out.println("Getting all employess");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getLocation());

		}

	}

	public static void getByLetter() {
		System.out.println("counting the no of employees whose name starting with s");
		Long name = list.stream().map(Employee::getName).filter(s -> s.startsWith("S")).collect(Collectors.counting());
		System.out.println(name);
	}

	public static void getByLocation() {
		System.out.println("All the Employees with location 'Hyderabad'");
		list.stream().parallel().filter(e -> e.getLocation().contains("Hyderabad") ? true : false)
				.forEach(System.out::println);

	}

	public static void getSalary() {
		System.out.println("Finding Salary i.e is greaterthan 50000");
		list.stream().filter(s -> s.getSalary() > 50000).forEach(System.out::println);
	}

	public static void getNameBySort() {

		Collections.sort(list, (o1, o2) -> (o1.getName().compareTo(o2.getName())));
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

	public static void getLocationBySort() {
		Collections.sort(list, (o1, o2) -> (o1.getLocation().compareTo(o2.getLocation())));
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void getDetailsByLocation() {
		
		Map<String, List<Employee>> map = new HashMap<>();
		map= list.stream().collect(Collectors.groupingBy(Employee::getLocation));
		System.out.println("find by location");
		System.out.println(map);
		
		
		

	}

	public static void getByChoice() {
		getAll();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to Find the Employee count whose name starts with 'S'");
			System.out.println("Enter 2 to Print the Employees with location Hyderabad");
			System.out.println("Enter 3 to Print the Employees based on Locations");
			System.out.println("Enter 4 to Check if any Employee's Salary is > 50000");
			System.out.println("Enter 5 to sort EmployeeList based on Name");
			System.out.println("Enter 6 toto sort EmployeeList based on Location");

			System.out.println("Please enter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("The Employee count whose name starts with 'S'");
				EmployeeService.getByLetter();
				break;
			case 2:
				System.out.println("the Employees with location Hyderabad");
				EmployeeService.getByLocation();
				break;
			case 3:
				System.out.println("the Employees based on Locations");
				EmployeeService.getDetailsByLocation();
				break;
			case 4:
				System.out.println("the Employees Salary is greaterthan 50000");
				EmployeeService.getSalary();
				break;
			case 5:
				System.out.println("To the sort EmployeeList based on Name");
				EmployeeService.getNameBySort();
				;
				break;
			case 6:
				System.out.println("To the sort Employee List based on Location");
				EmployeeService.getLocationBySort();
				break;

			default:
				System.out.println("Please enter Valid choice:");
				
				
			}
			System.out.println("Do You want to Continue ?");
			String str= scanner.next();
			if(!str.equalsIgnoreCase("y")) {
				break;
			}

		
		}scanner.close();
	}
	

}
