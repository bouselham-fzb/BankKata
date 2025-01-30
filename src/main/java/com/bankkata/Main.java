package com.bankkata;

public class Main {
    public static void main(String[] args){

        TransactionRepository transactionRepository = new TransactionRepository();
        StatementPrinter statementPrinter = new StatementPrinter();
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(1000);
        account.deposit(2000);
        account.withdrawal(500);

        account.printStatement();

    }
}
