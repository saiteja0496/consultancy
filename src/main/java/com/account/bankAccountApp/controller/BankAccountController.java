package com.account.bankAccountApp.controller;

import com.account.bankAccountApp.model.Accounts;
import com.account.bankAccountApp.model.Tranactions;
import com.account.bankAccountApp.service.BankAccountServiceImpl;
import com.account.bankAccountApp.service.TransactionDetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("accounts")
@Api(tags = { "Account Balance and Transactions History REST endpoints" })
public class BankAccountController {


    @Autowired
    private BankAccountServiceImpl bankAccountService;

    @Autowired
    private TransactionDetailsServiceImpl TransactionDetailsService;


    @GetMapping(path = "/findallAccounts")
    @ApiOperation(value = "Get account details", notes = "Find All account details")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public ResponseEntity<Object> getByAccountNumber() {
        return bankAccountService.findByAllAccountNumber();
    }

    @GetMapping(path = "/{accountNumber}")
    @ApiOperation(value = "Get account details", notes = "Find account details by account number")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public Accounts getByAccountNumber(@PathVariable String accountNumber) {
        return bankAccountService.findByAccountNumber(accountNumber);
    }

    @PostMapping(path = "/add/newaccountDetails")
    @ApiOperation(value = "Add a new account", notes = "Create An New Account Details.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
           @ApiResponse(code = 400, message = "Bad Request"),
           @ApiResponse(code = 500, message = "Internal Server Error") })
    public ResponseEntity<Object> addNewAccount(@RequestBody Accounts accounts) {
        return bankAccountService.addNewAccount(accounts);
    }


    @PostMapping(path = "/add/transactions")
    @ApiOperation(value = "Add a new account", notes = "Create An New Transaction Details.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })

    public ResponseEntity<Object> withdrawordepositingAmount(@RequestBody Tranactions tranactions) {
        return TransactionDetailsService.addWithdraworDepositTransactionDetails(tranactions);
    }

    @GetMapping(path = "/accountno/TransactionHistory")
    @ApiOperation(value = "Get account details", notes = "Find account details by account number")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public List<Tranactions> getTranasHistroy() {
        return TransactionDetailsService.findTransactionHistroy();
    }

    @GetMapping(path = "/accountno/{accountnumber}")
    @ApiOperation(value = "Get account details", notes = "Find account details by account number")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public Tranactions getTranasByAccountNumber(@PathVariable String accountnumber) {
        return TransactionDetailsService.findByAccountNumber(accountnumber);
    }

    @GetMapping(path = "/accountno/{accountNumber}/trans/{type}/Start/{sdate}/end/{edate}")
    @ApiOperation(value = "Get account details", notes = "Find account details by account number")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public List<Tranactions> getByAccountNumberTypeandDateRange(@PathVariable String accountNumber, @PathVariable String type,
                                                                @PathVariable String sdate, @PathVariable String edate) {
        return TransactionDetailsService.findAccountNumberTypeandDateRange(accountNumber,type,sdate,edate);

    }


    @GetMapping(path = "/accountno/{accountNumber}/Start/{sdate}/end/{edate}")
    @ApiOperation(value = "Get account details", notes = "Find account details by account number")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public List<Tranactions> getByAccountNumberandDateRange(@PathVariable String accountNumber,
                                                                @PathVariable String sdate, @PathVariable String edate) {
        return TransactionDetailsService.accountNumberandDateRange(accountNumber,sdate,edate);

    }




}
