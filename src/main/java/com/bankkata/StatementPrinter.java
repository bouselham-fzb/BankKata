package com.bankkata;

import javax.xml.transform.stream.StreamSource;
import java.util.List;

public class StatementPrinter {
    public void print(List<Transaction> transactions){
        System.out.println("Date || Amount  || Balance");
        int balance = 0;
        for (Transaction transaction : transactions){
            balance += transaction.getAmount();

        }
        for (int i= transactions.size()-1; i>=0 ; i--){
            Transaction transaction = transactions.get(i);
            System.out.printf("%s   ||   %d   ||   %d%n", transaction.getDate(), transaction.getAmount(), balance);
            balance -= transaction.getAmount();
        }
    }
}
