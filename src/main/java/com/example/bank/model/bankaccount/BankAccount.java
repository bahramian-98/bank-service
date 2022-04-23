package com.example.bank.model.bankaccount;

import com.example.bank.model.customer.Customer;
import com.example.bank.model.core.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BANK_ACCOUNT")
public class BankAccount extends BaseEntity {

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountType;


    /**
     * انواع حساب های بانکی
     */
    public enum AccountType{
        DEPOSIT, // سپرده
        LOAN // قرض الحسنه
    }

}
