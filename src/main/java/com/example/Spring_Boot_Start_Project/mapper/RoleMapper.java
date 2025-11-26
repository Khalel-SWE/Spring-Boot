package com.example.Spring_Boot_Start_Project.mapper;

import com.example.Spring_Boot_Start_Project.dto.RoleDto;
import com.example.Spring_Boot_Start_Project.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<Role> toRoleList(List<RoleDto> roleDtos);
    List<RoleDto> toRoleDtoList(List<Role> roles);
}
