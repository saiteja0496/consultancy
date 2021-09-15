package com.account.bankAccountApp.utils;

import com.account.bankAccountApp.entity.AccountBalance;
import com.account.bankAccountApp.entity.TransactionDetails;
import com.account.bankAccountApp.model.Accounts;
import com.account.bankAccountApp.model.Tranactions;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankUtils {

    public AccountBalance convertToAccountEntity(Accounts accounts) {
        return AccountBalance.builder()
                .accountNumber(accounts.getAccountNumber())
                .bal_amount(accounts.getAmount())
                .lastUpdateTimestamp(dateFormat())
                .build();
    }

    public Accounts convertToAccountModel(AccountBalance accountBalance) {
        return Accounts.builder()
                .accountNumber(accountBalance.getAccountNumber())
                .amount(accountBalance.getBal_amount())
                .lastUpdateTimestamp(dateFormat())
                .build();
    }

    public Tranactions convertToTransactionModel(TransactionDetails transactionDetails) {
        return Tranactions.builder()
                .accountNumber(transactionDetails.getAccountNumber())
                .type(transactionDetails.getType())
                .transactionTs(transactionDetails.getTransactionTs())
                .amount(transactionDetails.getAmount())
                .build();
    }

    public TransactionDetails convertToTransActionsEntity(Tranactions tranactions) {
        return  TransactionDetails.builder()
                .accountNumber(tranactions.getAccountNumber())
                .transactionTs(dateFormat())
                .type(tranactions.getType())
                .amount(tranactions.getAmount())
                .build();
    }


    public String dateFormat() {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        String date =formatter.format(new Date());
        return date;
    }

    public List<Tranactions> ConvertTOTransactionModelList(List<TransactionDetails> transactionhistory) {

       return transactionhistory.stream().map(transactionDetails -> new Tranactions(transactionDetails.getAccountNumber(),transactionDetails.getTransactionTs(),
                       transactionDetails.getType(),transactionDetails.getAmount())
                ).collect(Collectors.toList());


    }
}
