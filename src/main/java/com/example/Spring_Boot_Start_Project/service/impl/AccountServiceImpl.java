package com.example.Spring_Boot_Start_Project.service.impl;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import com.example.Spring_Boot_Start_Project.mapper.AccountMapper;
import com.example.Spring_Boot_Start_Project.model.Account;
import com.example.Spring_Boot_Start_Project.model.Role;
import com.example.Spring_Boot_Start_Project.repo.AccountRepo;
import com.example.Spring_Boot_Start_Project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    private AccountMapper accountMapper;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper, AccountRepo accountRepo, @Lazy PasswordEncoder passwordEncoder) {
        this.accountMapper = accountMapper;
        this.accountRepo = accountRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AccountDto getByUserName(String userName) {

        Optional<Account> account = accountRepo.findByUserName(userName);

        if (!account.isPresent()) {
            throw new RuntimeException("user name not exist");
        }
        return accountMapper.toAccountDto(account.get());
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        if (!accountRepo.findByUserName(accountDto.getUserName()).isPresent()) {
            throw new RuntimeException("user name not exist");
        }

        Account account = accountMapper.toAccount(accountDto);
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//        Role role = new Role();
//        role.setRoleName("USER");
//        role.setAccount(account);
//        account.setRoles(List.of(role));

        List<Role> roles = Collections.singletonList(new Role(account, "USER"));
        account.setRoles(roles);

        return accountMapper.toAccountDto(accountRepo.save(account));
    }
}
