package com.example.bank.model.user;

import com.example.bank.model.core.ResponseDTO;
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
