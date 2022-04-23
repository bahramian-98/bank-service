package com.example.bank.responsedto;

import com.example.bank.responsedto.core.ResponseDTO;
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
