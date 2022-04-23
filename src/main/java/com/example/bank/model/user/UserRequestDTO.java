package com.example.bank.model.user;

import com.example.bank.model.core.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO extends RequestDTO {

    @NotEmpty(message = "نام کاربری، مشخص نشده است!")
    private String userName;

    @NotEmpty(message = "رمز عبور، مشخص نشده است!")
    private String password;

    @NotEmpty(message = "نام و نام خانوادگی کاربر، مشخص نشده است!")
    private String fullName;
}
