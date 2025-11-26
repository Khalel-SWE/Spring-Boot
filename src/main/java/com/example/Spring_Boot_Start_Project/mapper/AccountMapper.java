package com.example.Spring_Boot_Start_Project.mapper;

import com.example.Spring_Boot_Start_Project.dto.AccountDto;
import com.example.Spring_Boot_Start_Project.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

//    @Mapping(source = "specId", target = "id")
    Account toAccount(AccountDto accountDto);

//    @Mapping(target = "address", ignore = true)
//    @Mapping(source = "id", target = "specId")
    AccountDto toAccountDto(Account account);

    List<Account> toAccountList (List<AccountDto> accountDtos);
    List<AccountDto> toAccountDtoList (List<Account> accounts);
}
