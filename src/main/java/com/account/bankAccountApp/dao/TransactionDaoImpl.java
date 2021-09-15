package com.account.bankAccountApp.dao;

import com.account.bankAccountApp.entity.AccountBalance;
import com.account.bankAccountApp.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionDaoImpl extends JpaRepository<TransactionDetails,String> {

    public Optional<TransactionDetails> findByAccountNumber(String accountNumber);

   // public List<TransactionDetails> findByAccountNumberdateRange(String Accno, String type);
}
