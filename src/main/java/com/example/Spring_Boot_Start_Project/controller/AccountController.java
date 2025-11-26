package com.example.Spring_Boot_Start_Project.controller;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import com.example.Spring_Boot_Start_Project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AccountController {


    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/user")
    ResponseEntity<AccountDto> getStudentById(@RequestParam String userName) {
        return ResponseEntity.ok(accountService.getByUserName(userName));
    }
}
