package com.example.bank.model;

import com.example.bank.model.BankAccount;
import com.example.bank.model.core.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

   /* @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "IS_DELETED")
    private Long deleted;*/

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "NATIONAL_CODE", nullable = false)
    private String nationalCode;

    @Column(name = "MOBILE_NUMBER", nullable = false)
    private String mobileNumber;

    @Column(name = "ADDRESS", nullable = false)
    private  String address;

}
