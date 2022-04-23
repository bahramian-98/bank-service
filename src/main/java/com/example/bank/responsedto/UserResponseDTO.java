package com.example.bank.responsedto;

import com.example.bank.responsedto.core.ResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class UserResponseDTO extends ResponseDTO {

    private String userName;
    //private String password;
    private String fullName;
}
