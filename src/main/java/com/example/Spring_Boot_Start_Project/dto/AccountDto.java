package com.example.Spring_Boot_Start_Project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;

    private String userName;

    private String password;

    private String phone;

    private String address;

    private List<RoleDto> roles;
}
