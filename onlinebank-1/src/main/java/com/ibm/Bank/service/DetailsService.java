package com.ibm.Bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Bank.entity.Bank;
import com.ibm.Bank.repository.BankRepository;

@Service
public class DetailsService {
	@Autowired
	public BankRepository BankR;
public List<Bank> getCustomersDetails(String id,String pass){
	List<Bank> details=new ArrayList<>();
	if(id.equals("199")&&pass.equals("admin123")) {
	//only with administrator credentials we can fetch all customer information
	Iterable<Bank> de=BankR.findAll();
	for(Bank b: de) {
		details.add(b);
	} //returning details of all the customers if the user is an administrator
	return details;
}
	Bank l=new Bank();
	l.setName("Sorry only with administrator credentials you can access all customer information");
	l.setBalance(0.0);
	l.setId("Wrong credentials for admin");
	l.setPasscode("Sorry wrong credentials");
	details.add(l);
	return details;
}
public String addDetails(Bank bank) {//To add the customers
	if(bank==null)
		return null;
	String id=bank.getId();
	if (BankR.findById(id).isPresent()) {
		return "Sorry customer with this ID already exists";
	}

	else {
		BankR.save(bank);
	return "customer created";
	}
}

public String updateDetails(Bank bank,String id,String pass) {//To update details by Id and passcode
	if(bank.getId().equals(id)){
	Bank e=BankR.findById(id).get();
	if(e!=null&&e.getPasscode().equals(pass)) {
	BankR.save(bank);
	return "Details updated successfully";
}
	else return "Invalid user password/Id";
}
	return "Customer id that you want to change is already in use";
}
public String withdraw(String id,String pass,String withdrawamt) {
	Bank e=BankR.findById(id).get();
	if(e!=null&&e.getPasscode().equals(pass)){    //if credentials matches then updating the balance
	double amt=e.getBalance()-Double.parseDouble(withdrawamt);
	if(amt>=0) {
	e.setBalance(amt);
	BankR.deleteById(id);
	BankR.save(e); 
	String s="Transaction Complete "+"Remaining balance="+amt;
	return s;
	}
		}
return "Transaction failed";
}
public String delete(String id,String pass) {
	Bank e=BankR.findById(id).get();
	if(e!=null&&e.getPasscode().equals(pass)){    //if credentials matches then deleting
	BankR.deleteById(id);
	return "Customer deleted successfully";
}
	return "Invalid User Id/Password";
}
public String Deposit(String id,String pass,String deposit) {
		Bank e=BankR.findById(id).get();
		if(e!=null&&e.getPasscode().equals(pass)){    //if credentials matches then updating the balance
		double amt=e.getBalance()+Double.parseDouble(deposit);
		e.setBalance(amt);
		BankR.deleteById(id);
		BankR.save(e);
		String s="Transaction Complete "+"Remaining balance="+amt;
		return s;
		}
	return "Transaction Failed";
}
	public Bank GetCustomerDetail(String id,String pass) {
		Bank e=BankR.findById(id).get();// returning the information of a customer if his/her credentials are valid
		if(e!=null&&e.getPasscode().equals(pass))
		return e;
		return null;
}
}
