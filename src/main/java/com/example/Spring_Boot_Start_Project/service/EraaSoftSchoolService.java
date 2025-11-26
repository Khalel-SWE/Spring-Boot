package com.example.Spring_Boot_Start_Project.service;

import com.example.Spring_Boot_Start_Project.dto.EraaSoftSchoolDTO;

import java.util.List;

public interface EraaSoftSchoolService {
    EraaSoftSchoolDTO save (EraaSoftSchoolDTO EraaSoftSchoolDTO);
    EraaSoftSchoolDTO update (EraaSoftSchoolDTO EraaSoftSchoolDTO);
    boolean delete (Long id);
    List<EraaSoftSchoolDTO> getAll();
    EraaSoftSchoolDTO getById (Long id);
    EraaSoftSchoolDTO getByUserName (String userName);
}
