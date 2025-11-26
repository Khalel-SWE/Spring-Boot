package com.example.Spring_Boot_Start_Project.mapper;

import com.example.Spring_Boot_Start_Project.dto.EraaSoftSchoolDTO;
import com.example.Spring_Boot_Start_Project.model.EraaSoftSchool;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// EraaSoftSchool  EraaSoftSchoolDTO
@Mapper(componentModel = "spring")
public interface EraaSoftMapper {

//    EraaSoftMapper ERAA_SOFT_MAPPER = Mappers.getMapper(EraaSoftMapper.class);

    @Mapping(source = "fullUserName", target = "userName")
    EraaSoftSchool toEraaSoftSchool (EraaSoftSchoolDTO eraaSoftSchoolDTO);
    @Mapping(source = "userName", target = "fullUserName")
    EraaSoftSchoolDTO toEraaSoftSchoolDto (EraaSoftSchool eraaSoftSchool);
    List<EraaSoftSchool> toEraaSoftSchoolList (List<EraaSoftSchoolDTO> eraaSoftSchoolDTOS);
    List<EraaSoftSchoolDTO> toEraaSoftSchoolDtoList (List<EraaSoftSchool> eraaSoftSchools);
}
