package com.cjc.in.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.stereotype.Service;

import com.cjc.in.exception.CIDInvalidException;
import com.cjc.in.exception.KeyNotFoundException;
import com.cjc.in.model.Customer;

@Service
public class CustomerService {

	Map<String, List<Customer>> map =new HashMap<String, List<Customer>>();
	
	
	public List<Customer> getAllCustomers(String key) {
		List<Customer> clist1 = new ArrayList<Customer>();
		clist1.add(new Customer(101,"ABC","Pune"));
		clist1.add(new Customer(102,"XYZ","Pune"));
		clist1.add(new Customer(103,"PQR","Pune"));
		
		map.put("l1",clist1);
		List<Customer> cl = null;
		  Set<String> keySet = map.keySet();
		   
		    boolean flag = false;
		   
		    for(String key1 : keySet) {
		    	
		    	if(key1.equals(key)) {
		    	cl=map.get(key1);
		    	flag = true;
		    	}
		    }
		  if(flag)
		return cl;
		  else
			throw new KeyNotFoundException();  
	}


	public String insertCust(Customer cust) {
		
		  int cid = cust.getCid();
		  if(cid>99&&cid<1000) {
			
			  return "Customer Inserted.....";
		  }
		  else {
			  throw new CIDInvalidException();
		  }
		  
		  
		
	}
}
