package com.example.bank.model.bankaccount;

import com.example.bank.model.core.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequestDTO  extends RequestDTO {

    @NotEmpty(message = "شماره حساب وارد نشده است!")
    private String accountNumber;

    @NotNull(message = "نوع حساب، مشخص نشده است!")
    private BankAccount.AccountType accountType;

    @NotNull(message = "شناسه مشتری، مشخص نشده است!")
    @Positive(message = "شناسه مشتری، نمی تواند صفر یا عددی منفی باشد!")
    private Long customerId;

}
