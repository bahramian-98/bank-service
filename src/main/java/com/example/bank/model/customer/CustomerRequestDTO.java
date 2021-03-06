package com.example.bank.model.customer;

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
public class CustomerRequestDTO extends RequestDTO {

    @NotEmpty(message = "نام، مشخص نشده است!")
    private String firstName;

    @NotEmpty(message = "نام خانوادگی، مشخص نشده است!")
    private String lastName;

    @NotEmpty(message = "نام خانوادگی، مشخص نشده است!")
    private String nationalCode;

    @NotEmpty(message = "موبایل، مشخص نشده است!")
    private String mobileNumber;

    @NotEmpty(message = "آدرس، مشخص نشده است!")
    private String address;
}
