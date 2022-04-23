package com.example.bank.controller;

import com.example.bank.model.bankaccount.BankAccountRequestDTO;
import com.example.bank.model.bankaccount.BankAccountResponseDTO;
import com.example.bank.service.BankAccountService;
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
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @ApiOperation(value = "ثبت حساب بانکی برای مشتری")
    @PostMapping(value = "/bankAccount/save")
    public ResponseEntity<Long> save(@RequestBody @Valid BankAccountRequestDTO request) {
        Long id = bankAccountService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @ApiOperation(value = "لیست حساب های بانکی")
    @GetMapping("/bankAccount")
    public ResponseEntity<Page<BankAccountResponseDTO>> list(@PageableDefault Pageable pageable) {
        Page<BankAccountResponseDTO> results = bankAccountService.list(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @ApiOperation(value = "لیست حساب های بانکی یک مشتری")
    @GetMapping("/bankAccount/findByCustomerId")
    public ResponseEntity<Page<BankAccountResponseDTO>> findByCustomerId(@RequestParam Long customerId, @PageableDefault Pageable pageable) {
        Page<BankAccountResponseDTO> results = bankAccountService.findByCustomerId(customerId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }
}
