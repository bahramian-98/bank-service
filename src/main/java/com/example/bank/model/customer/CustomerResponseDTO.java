package com.example.bank.model.customer;

import com.example.bank.model.core.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CustomerResponseDTO extends ResponseDTO {

    private String firstName;
    private String lastName;
    private String nationalCode;
    private String mobileNumber;
    private String address;
}
