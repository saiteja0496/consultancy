package com.account.bankAccountApp.service;

import com.account.bankAccountApp.model.Tranactions;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface TransactionDetailsService {

    public ResponseEntity<Object> addWithdraworDepositTransactionDetails(Tranactions tranactions);


    Tranactions findByAccountNumber(String accountNumber);

    public List<Tranactions> findTransactionHistroy();

    List<Tranactions> findAccountNumberTypeandDateRange(String accountNumber, String type,String sdate,String edate);

    List<Tranactions> accountNumberandDateRange(String accountNumber, String sdate, String edate);


}
