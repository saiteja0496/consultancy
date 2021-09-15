package com.account.bankAccountApp.service;

import com.account.bankAccountApp.dao.BankAccountDaoImpl;
import com.account.bankAccountApp.dao.TransactionDaoImpl;
import com.account.bankAccountApp.entity.AccountBalance;
import com.account.bankAccountApp.model.Accounts;
import com.account.bankAccountApp.utils.BankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountDaoImpl bankaccountdao;
    @Autowired
    private TransactionDaoImpl transactionRepository;
    @Autowired
    private BankUtils bankUtils;


  @Override
  @Transactional
    public ResponseEntity<Object> findByAllAccountNumber() {
    try {
    Iterable<AccountBalance> accountEntityOpt = bankaccountdao.findAll();
    return ResponseEntity.status(HttpStatus.FOUND).body(accountEntityOpt);
   }catch (Exception e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Numbers not found.");
  }
  }

    @Override
    @Transactional
    public Accounts findByAccountNumber(String accountnumber) {

            Optional<AccountBalance> accountEntityOpt = bankaccountdao.findByAccountNumber(accountnumber);

        if(accountEntityOpt.isPresent())
            return bankUtils.convertToAccountModel(accountEntityOpt.get());

        return null;
        }


    @Override
    @Transactional
    public ResponseEntity<Object> addNewAccount(Accounts account) {
      try {
          bankaccountdao.save(bankUtils.convertToAccountEntity(account));
      }catch (Exception e){
          e.getCause().getMessage();
      }

        return ResponseEntity.status(HttpStatus.CREATED).body("New Account created successfully.");
    }

}
