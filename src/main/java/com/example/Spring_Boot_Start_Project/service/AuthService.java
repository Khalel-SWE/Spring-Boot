package com.example.Spring_Boot_Start_Project.service;

import com.example.Spring_Boot_Start_Project.controller.vm.AuthRequestVm;
import com.example.Spring_Boot_Start_Project.controller.vm.AuthResponseVm;
import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import jakarta.transaction.SystemException;

public interface AuthService {

    AuthResponseVm login (AuthRequestVm authRequestVm);

    AuthResponseVm signup (AccountDto accountDto) throws SystemException;
}
