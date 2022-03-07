package com.bhavna.HibernateCurd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.HibernateCurd.Entity.PolicyHolder;
import com.bhavna.HibernateCurd.Service.LifeInsuranceService;

@RestController
public class LifeInsuranceController {
	
		@Autowired
	private LifeInsuranceService service;
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<PolicyHolder> getPolicyHolders(){
		return service.getPolicyHolders();
		
	}
	@PostMapping("/save")
  public String savePolicyHolder(@RequestBody PolicyHolder policyHolder) {
	  service.save(policyHolder);
	return "details saved....";
  }
	@GetMapping("/getAll/{policyId}")
	public PolicyHolder getPolicyHolderById(@PathVariable int policyId) {
		return service.getHolderById(policyId);
		
	}
	
	@PutMapping("/getAll/{policyId}")
	public String updateHolder(@PathVariable int policyId ,@RequestBody PolicyHolder policyHolder) {
		
		service.updateHolder(policyId, policyHolder);
		return "update Successfully..";
		
		
	}
}