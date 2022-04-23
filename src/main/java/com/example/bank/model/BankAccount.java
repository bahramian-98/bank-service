package com.example.bank.model;

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

    /*@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "IS_DELETED")
    private Long deleted;*/

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
