package com.example.bank.model.bankaccount;

import com.example.bank.model.customer.CustomerResponseDTO;
import com.example.bank.model.core.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class BankAccountResponseDTO extends ResponseDTO {

    private String accountNumber;
    private String accountType;
    private String assigned;
    private CustomerResponseDTO customerResponseDTO;

}
