package com.account.bankAccountApp.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tranactions {
    private String accountNumber;
    private String transactionTs;
    private String type;
    private Double amount;
}
