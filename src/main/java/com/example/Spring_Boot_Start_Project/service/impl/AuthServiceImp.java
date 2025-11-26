package com.example.Spring_Boot_Start_Project.service.impl;

import com.example.Spring_Boot_Start_Project.controller.vm.AuthRequestVm;
import com.example.Spring_Boot_Start_Project.controller.vm.AuthResponseVm;
import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import com.example.Spring_Boot_Start_Project.service.AccountService;
import com.example.Spring_Boot_Start_Project.service.AuthService;
import com.example.Spring_Boot_Start_Project.service.token.TokenHandler;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImp implements AuthService {


    private AccountService accountService;

    private TokenHandler tokenHandler;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImp(AccountService accountService, PasswordEncoder passwordEncoder, TokenHandler tokenHandler) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
        this.tokenHandler = tokenHandler;
    }

    public AuthServiceImp(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public AuthResponseVm login(AuthRequestVm authRequestVm) {

        AccountDto accountDto = accountService.getByUserName(authRequestVm.getUserName());

        if (!passwordEncoder.matches(authRequestVm.getPassword(), accountDto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return new AuthResponseVm(tokenHandler.createToken(accountDto));
    }

    @Override
    public AuthResponseVm signup(AccountDto accountDto) throws SystemException {
        AccountDto savedAccountDto = accountService.createAccount(accountDto);
        if (Objects.isNull(savedAccountDto)) {
            throw new SystemException("account not created");
        }
        return new AuthResponseVm(tokenHandler.createToken(savedAccountDto));
    }
}
