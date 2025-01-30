package com.bankkata;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StatementPrinterTest {
    @Test
    void should_print_transactions_in_correct_order(){
        List<Transaction> transactions = Arrays.asList(
                new Transaction(LocalDate.of(2012, 1, 10),1000),
                new Transaction(LocalDate.of(2012, 1, 13),2000),
                new Transaction(LocalDate.of(2012, 1, 13),-500)
        );

        StatementPrinter statementPrinter = new StatementPrinter();
        String expectedOutput = """
                Date       | Amount  | Balance
                14-01-2012 | -500    | 2500
                13-01-2012 | 2000    | 3000
                10-01-2012 | 1000    | 1000
                """;

        assertDoesNotThrow(() -> statementPrinter.print(transactions));
    }
}
