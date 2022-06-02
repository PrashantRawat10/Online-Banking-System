package com.ibm.Bank.controller;

import java.util.List;
import com.ibm.Bank.entity.*;
import com.ibm.Bank.service.DetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
@CrossOrigin
public class ControllerClass {
	@Autowired
	private DetailsService ds;
	@PostMapping("/adddetails")// http://localhost:1111/customers/CustomerCreation
	public String addDetails(@RequestBody Bank bank) {
		 return ds.addDetails(bank);
	}
	@GetMapping("/getAlldetails/{id}/{pass}")//only with administrator credentials we can fetch all the customer information
public List<Bank> getDetails(@PathVariable String id,@PathVariable String pass){
	return ds.getCustomersDetails(id,pass);
}
	@PutMapping("/withdraw/{id}/{pass}/{withdrawamt}")
	public String WithdrawMoney(@PathVariable String id,@PathVariable String pass,@PathVariable String withdrawamt) {
		 return ds.withdraw(id,pass,withdrawamt);
	}
	@PutMapping("/deposit/{id}/{pass}/{deposit}")
	public String DepositMoney(@PathVariable String id,@PathVariable String pass,@PathVariable String deposit) {
		return  ds.Deposit(id,pass,deposit);
	}
	@PutMapping("/update/{id}/{pass}")
	public String updateDetails(@RequestBody Bank bank,@PathVariable String id,@PathVariable String pass) {
		return ds.updateDetails(bank, id,pass);
	}
	@PutMapping("/delete/{id}/{pass}")
	public String Delete(@PathVariable String id,@PathVariable String pass) {
		 return ds.delete(id,pass);
	}
	@GetMapping("/getdetail/{id}/{pass}")//user can fetch his details based on his credentials
public Bank getCustomerDetail(@PathVariable String id,@PathVariable String pass){
	return ds.GetCustomerDetail(id,pass);
}
}
 
