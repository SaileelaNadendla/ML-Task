package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.EMP;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/get")
	public String get() {
		return "Heloo";
		
	}
	 @GetMapping("/employees")
	public String getEMP(Model theModel) {
		List<EMP> theEmp =empService.getEmployees();
		theModel.addAttribute("employees", theEmp);
		return "getEmp";
		
	}
	

}
