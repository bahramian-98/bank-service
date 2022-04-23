package com.example.bank.controller;

import com.example.bank.model.user.UserRequestDTO;
import com.example.bank.model.user.UserResponseDTO;
import com.example.bank.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "ثبت کاربر")
    @PostMapping(value = "/user/save")
    public ResponseEntity<Long> save(@RequestBody @Valid UserRequestDTO request) {
        Long id = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @ApiOperation(value = "لیست کاربران")
    @GetMapping("/user")
    public ResponseEntity<Page<UserResponseDTO>> list(@PageableDefault Pageable pageable) {
        Page<UserResponseDTO> results = userService.list(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }
}
