package com.example.Spring_Boot_Start_Project.service.impl.userdetailsservice;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import com.example.Spring_Boot_Start_Project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public class CustomUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    @Autowired
    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountDto accountDto = accountService.getByUserName(username);
        // validate the auth
        return new CustomUserDetails(accountDto); // password, roles
    }
}
