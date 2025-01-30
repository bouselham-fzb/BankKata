package com.bankkata;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {
    @Test
    void should_store_deposit_transaction(){
        TransactionRepository tansactionRepository = mock(TransactionRepository.class);
        StatementPrinter statementPrinter = mock(StatementPrinter.class);
        Account account = new Account(tansactionRepository, statementPrinter);

        account.deposit(1000);
        verify(tansactionRepository).addTransaction(1000);
    }

    @Test
    void should_store_withdrawal_transaction(){
        TransactionRepository tansactionRepository = mock(TransactionRepository.class);
        StatementPrinter statementPrinter = mock(StatementPrinter.class);
        Account account = new Account(tansactionRepository, statementPrinter);

        account.withdrawal(500);
        verify(tansactionRepository).addTransaction(-500);
    }

    @Test
    void should_print_statement(){
        TransactionRepository tansactionRepository = mock(TransactionRepository.class);
        StatementPrinter statementPrinter = mock(StatementPrinter.class);
        Account account = new Account(tansactionRepository, statementPrinter);

        account.printStatement();
        verify(statementPrinter).print(tansactionRepository.getAllTransactions());
    }
}
