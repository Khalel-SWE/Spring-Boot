package com.example.Spring_Boot_Start_Project.service;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;

public interface AccountService {

    AccountDto getByUserName(String userName);
    AccountDto createAccount(AccountDto accountDto);
}
