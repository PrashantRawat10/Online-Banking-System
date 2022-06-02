package com.ibm.Bank.repository;
import com.ibm.Bank.entity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank,String>{

}
