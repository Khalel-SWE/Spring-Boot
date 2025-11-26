package com.example.Spring_Boot_Start_Project.service.impl.userdetailsservice;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private AccountDto accountDto;

    public CustomUserDetails(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

//        can be retuned in this way
//        List<SimpleGrantedAuthority> roles = new ArrayList<>();
//
//        for (RoleDto roleDto : accountDto.getRoles()) {
//            roles.add(new SimpleGrantedAuthority(roleDto.getRoleName()));
//        }
//
//        return roles;
//        or in this way
        return accountDto.getRoles().stream().map(roleDto ->
                        new SimpleGrantedAuthority("ROLE_" + roleDto.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return "{noop}" + accountDto.getPassword();
    }

    @Override
    public String getUsername() {
        return accountDto.getUserName();
    }
}
