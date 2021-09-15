package com.account.bankAccountApp.model;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Accounts {
    private String accountNumber;
    private String lastUpdateTimestamp;
    private Double amount;
}
