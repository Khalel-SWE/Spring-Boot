package com.example.Spring_Boot_Start_Project.service.impl.provider;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import com.example.Spring_Boot_Start_Project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

//@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private AccountService accountService;

    @Autowired
    public CustomAuthProvider(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        AccountDto accountDto = accountService.getByUserName(userName);

        if (accountDto.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Password");
        }

        List<SimpleGrantedAuthority> roles = getAuthorities(accountDto);

        return new UsernamePasswordAuthenticationToken(userName, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<SimpleGrantedAuthority> getAuthorities(AccountDto accountDto) {
        return accountDto.getRoles().stream().map(roleDto ->
                new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());
    }
}
