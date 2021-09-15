package com.account.bankAccountApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ACCOUNT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ACC_ID")
    private int id;

    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name="LASTUPDATETIMESTAMP")
    private String lastUpdateTimestamp;

    @Column(name="AMOUNT")
    private Double bal_amount;
}
