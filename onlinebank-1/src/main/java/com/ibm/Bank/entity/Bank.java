package com.ibm.Bank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banking_application")
public class Bank {
	@Id
private String id;
private String passcode;
private String name;
private Double balance;
public String getPasscode() {
	return passcode;
}
public void setPasscode(String passcode) {
	this.passcode = passcode;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Bank(String id, String name, Double balance) {
	super();
	this.id = id;
	this.name = name;
	this.balance = balance;
}

public Bank() {
	super();
}
public Double getBalance() {
	return balance;
}
public void setBalance(Double balance) {
	this.balance = balance;
}
}
