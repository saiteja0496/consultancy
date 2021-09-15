package com.account.bankAccountApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="TNX_ID")
    private int id;

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="TRANSACTIONTS")
    private String transactionTs;

    @Column(name="TYPE")
    private String type;

    @Column(name="AMOUNT")
    private Double amount;
}
