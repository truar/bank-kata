package com.zenikata.bank.presenter;

import com.zenikata.bank.domain.BankAccount;
import com.zenikata.bank.domain.Transaction;
import com.zenikata.bank.domain.TransactionType;
import org.apache.commons.lang3.StringUtils;

import javax.swing.tree.TreeNode;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringReporter implements Reporter {

    private static final String SEPARATOR = "|";
    private static final String EOL = "\n";

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public String print(BankAccount bankAccount) {
        List<Transaction> transactions = bankAccount.transactions();
        StringBuilder sb = new StringBuilder();
        reportBankAccount(bankAccount, transactions, sb);
        return sb.toString();
    }

    private void reportBankAccount(BankAccount bankAccount, List<Transaction> transactions, StringBuilder sb) {
        sb.append("Your current balance is: ").append(formatAmountForReport(bankAccount.balance())).append(EOL);
        for(Transaction transaction : transactions) {
            TransactionTypeReport type = TransactionTypeReport.fromTransactionType(transaction.type());
            sb.append(StringUtils.rightPad(type.toString(), 10));
            sb.append(SEPARATOR);
            sb.append(StringUtils.rightPad(formatAmountForReport(transaction.amount()), 10));
            sb.append(SEPARATOR);
            sb.append(StringUtils.rightPad(formatDateForReport(transaction.transactionDateTime()), 10));
            sb.append(SEPARATOR);
            sb.append(EOL);
        }
    }

    private String formatAmountForReport(BigDecimal amount) {
        return amount.setScale(2).toString();
    }

    private String formatDateForReport(LocalDateTime dateTime) {
        return formatter.format(dateTime);
    }

    private enum TransactionTypeReport {
        WITHDRAW,
        DEPOSIT;

        private static TransactionTypeReport fromTransactionType(TransactionType type) {
            switch (type) {
                case DEPOSIT: return TransactionTypeReport.DEPOSIT;
                case WITHDRAW: return  TransactionTypeReport.WITHDRAW;
                default: throw new IllegalArgumentException("The specified type is incorrect : " + type);
            }
        }
    }

}
