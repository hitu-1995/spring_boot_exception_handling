package com.cjc.in.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.in.model.Customer;

@RestController
@RequestMapping("/custApi")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping("/getAll/{key}")
	public ResponseEntity<List<Customer>> getAllCustome(@PathVariable String key) {
		log.info("getAllCustome Called....");
		List<Customer> list = service.getAllCustomers(key);
		log.info("getAllCustome ends ..");
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/inserCust")
	public ResponseEntity<String> inserCustomer(@RequestBody Customer cust) {
		String msg = service.insertCust(cust);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
}
