package com.example.bank.requestdto;

import com.example.bank.requestdto.core.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO extends RequestDTO {

    private String userName;
    private String password;
    private String fullName;
}
