package com.account.bankAccountApp.dao;

import com.account.bankAccountApp.entity.AccountBalance;
import com.account.bankAccountApp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BankAccountDaoImpl extends JpaRepository<AccountBalance, String> {
    public Optional<AccountBalance> findByAccountNumber(String accountNumber);
}
