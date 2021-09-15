package com.account.bankAccountApp.service;

import com.account.bankAccountApp.model.Accounts;
import org.springframework.http.ResponseEntity;


public interface BankAccountService {

    public ResponseEntity<Object> findByAllAccountNumber();

    public Accounts findByAccountNumber(String accountnumber);

    public ResponseEntity<Object> addNewAccount(Accounts account);

}