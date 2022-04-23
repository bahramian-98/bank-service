package com.example.bank.controller;

import com.example.bank.model.customer.CustomerRequestDTO;
import com.example.bank.model.customer.CustomerResponseDTO;
import com.example.bank.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    @ApiOperation(value = "ثبت کردن مشتری")
    @PostMapping(value = "/customer/save")
    public ResponseEntity<Long> save(@RequestBody @Valid CustomerRequestDTO request) {
        Long id = customerService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @ApiOperation(value = "یافتن اطلاعات مشتری بر اساس کد ملی")
    @GetMapping("/customer/byNationalCode")
    public ResponseEntity<Page<CustomerResponseDTO>> findByNationalCode(@RequestParam String nationalCode, @PageableDefault Pageable pageable) {
        Page<CustomerResponseDTO> results = customerService.findByNationalCode(nationalCode, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @ApiOperation(value = "لیست مشتریان")
    @GetMapping("/customer")
    public ResponseEntity<Page<CustomerResponseDTO>> list(@PageableDefault Pageable pageable) {
        Page<CustomerResponseDTO> results = customerService.list(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

}
