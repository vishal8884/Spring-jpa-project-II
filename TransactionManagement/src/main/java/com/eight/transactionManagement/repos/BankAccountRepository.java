package com.eight.transactionManagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.eight.transactionManagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer>{

}
