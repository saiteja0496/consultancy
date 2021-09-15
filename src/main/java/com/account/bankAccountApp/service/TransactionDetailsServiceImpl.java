package com.account.bankAccountApp.service;

import com.account.bankAccountApp.dao.TransactionDaoImpl;
import com.account.bankAccountApp.entity.TransactionDetails;
import com.account.bankAccountApp.model.Tranactions;
import com.account.bankAccountApp.utils.BankUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService{

    @Autowired
    private TransactionDaoImpl transactionDao;
    @Autowired
    private BankUtils bankUtils;
@Override
@Transactional
    public ResponseEntity<Object> addWithdraworDepositTransactionDetails(Tranactions tranactions) {
        try{
            transactionDao.save(bankUtils.convertToTransActionsEntity(tranactions));
           }catch (Exception e){
                e.getCause().getMessage();
           }
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction Details Deposit successfully.");
    }

    @Override
    @Transactional
    public Tranactions findByAccountNumber(String accountNumber) {
       Optional<TransactionDetails> transactionEntityopt= transactionDao.findByAccountNumber(accountNumber);
        if(transactionEntityopt.isPresent()) {
            return bankUtils.convertToTransactionModel(transactionEntityopt.get());
        }
        return null;
    }

    @Override
    @Transactional
    public List<Tranactions> findTransactionHistroy() {

       List<TransactionDetails> transactionhistory=transactionDao.findAll();
        return  bankUtils.ConvertTOTransactionModelList(transactionhistory);
    }


    @Transactional
    public List<Tranactions> findAccountNumberTypeandDateRange(String accountNumber, String type, String startDate, String endDate) {
        List<TransactionDetails> transactions=transactionDao.findAll();

        List<Tranactions> transac= transactions.stream().filter(trans ->trans.getAccountNumber().equalsIgnoreCase(accountNumber) && trans.getType().equalsIgnoreCase(type))
                .map(trans ->new Tranactions(trans.getAccountNumber(),trans.getTransactionTs(),trans.getType(),trans.getAmount())).collect(Collectors.toList());

        List<LocalDate> range =new ArrayList<>();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date startDat = null;
        Date endDat = null;
        LocalDate current;
        try {
             startDat =formatter.parse(startDate);
             endDat =formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LocalDate firstDate = startDat.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate secondDate =endDat.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
         current = firstDate;

        while (current.isBefore(secondDate)) {
            range.add(current);
            current = current.plusDays(1);
        }


        List<Tranactions> transacacti = new ArrayList<>();
        for(LocalDate expo:range){
            for(Tranactions trd :transac) {
                if (expo.isEqual(LocalDate.parse(trd.getTransactionTs()))){
                    transacacti.add(trd);
                }
            }

        }

        return transacacti;


    }

    @Override
    public List<Tranactions> accountNumberandDateRange(String accountNumber, String sdate, String edate) {
        {
            List<TransactionDetails> transactions = transactionDao.findAll();

            List<Tranactions> transac = transactions.stream().filter(trans -> trans.getAccountNumber().equalsIgnoreCase(accountNumber))
                    .map(trans -> new Tranactions(trans.getAccountNumber(), trans.getTransactionTs(), trans.getType(), trans.getAmount())).collect(Collectors.toList());

            List<LocalDate> range = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startDat = null;
            Date endDat = null;
            LocalDate current;
            try {
                startDat = formatter.parse(sdate);
                endDat = formatter.parse(edate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            LocalDate firstDate = startDat.toInstant().atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate secondDate = endDat.toInstant().atZone(ZoneId.systemDefault())
                    .toLocalDate();
            current = firstDate;

            while (current.isBefore(secondDate)) {
                range.add(current);
                current = current.plusDays(1);
            }


            List<Tranactions> transacactions = new ArrayList<>();
            for (LocalDate expo : range) {
                for (Tranactions trd : transac) {
                    if (expo.isEqual(LocalDate.parse(trd.getTransactionTs()))) {
                        transacactions.add(trd);
                    }
                }

            }

            return transacactions;


        }

    }
}
