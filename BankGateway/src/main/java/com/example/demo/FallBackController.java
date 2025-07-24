package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class FallBackController {


	 @GetMapping("/applicationStatusFallback")
	 public String applicationStatusServiceFallback() {
	  return "Application Status service is taking longer than expected\nPlease try after sometime";
	 }
	 
	 @GetMapping("/applicationDetailsFallback")
	 public String applicationDetailsServiceFallback() {
	  return "Application Status service is taking longer than expected\nPlease try after sometime";
	 }
	 
	 @GetMapping("/loanCustomerFallback")
	 public String loanCustomerServiceFallback() {
	  return "Loan Customer service is taking longer than expected\nPlease try after sometime";
	 }
	}

