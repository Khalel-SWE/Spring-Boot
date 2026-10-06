package com.example.Spring_Boot_Start_Project.service.impl;

import com.example.Spring_Boot_Start_Project.dto.EraaSoftSchoolDTO;
import com.example.Spring_Boot_Start_Project.mapper.EraaSoftMapper;
import com.example.Spring_Boot_Start_Project.model.EraaSoftSchool;
import com.example.Spring_Boot_Start_Project.repo.EraaSoftSchoolRepo;
import com.example.Spring_Boot_Start_Project.service.EraaSoftSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EraaSoftSchoolServiceImpl implements EraaSoftSchoolService {

    private EraaSoftSchoolRepo eraaSoftSchoolRepo;
    private EraaSoftMapper eraaSoftMapper;

    @Autowired
    public EraaSoftSchoolServiceImpl(EraaSoftSchoolRepo eraaSoftSchoolRepo, EraaSoftMapper eraaSoftMapper /*, ModelMapper modelMapper*/) {
        this.eraaSoftSchoolRepo = eraaSoftSchoolRepo;
        this.eraaSoftMapper = eraaSoftMapper;
//        this.modelMapper = modelMapper;
    }

    @Override
    public EraaSoftSchoolDTO save(EraaSoftSchoolDTO eraaSoftSchoolDTO) /*throws SystemException*/ {

        if (Objects.nonNull(eraaSoftSchoolDTO.getId())) {
            throw new RuntimeException("id must be null");
        }

        Optional <EraaSoftSchool> eraaSoftSchoolOp = eraaSoftSchoolRepo.findByUserName(eraaSoftSchoolDTO.getFullUserName());

        if (eraaSoftSchoolOp.isPresent()) {
            throw new RuntimeException("user name is exist");
        }

        EraaSoftSchool eraaSoftSchool = eraaSoftMapper.toEraaSoftSchool(eraaSoftSchoolDTO);

        eraaSoftSchool = eraaSoftSchoolRepo.save(eraaSoftSchool);

        eraaSoftSchoolDTO.setId(eraaSoftSchool.getId());

        return eraaSoftSchoolDTO; 
    }

    @Override
    public EraaSoftSchoolDTO update(EraaSoftSchoolDTO eraaSoftSchoolDTO) {
        if (Objects.isNull(eraaSoftSchoolDTO.getId())) {
            throw new RuntimeException("id must not be null");
        }

        EraaSoftSchool eraaSoftSchool = eraaSoftMapper.toEraaSoftSchool(eraaSoftSchoolDTO);

        eraaSoftSchoolRepo.save(eraaSoftSchool);

        return eraaSoftSchoolDTO;
    }

    // the wrong code
    @Override
    public boolean delete(Long id) {

        Optional<EraaSoftSchool> eraaSoftSchool = eraaSoftSchoolRepo.findById(id);

        if (eraaSoftSchool.isEmpty()) {
            return false;
        }

        eraaSoftSchoolRepo.deleteById(id);
        return true;
    }



    @Override
    public List<EraaSoftSchoolDTO> getAll() {
        List<EraaSoftSchool> eraaSoftSchools = eraaSoftSchoolRepo.findAll();
        if (CollectionUtils.isEmpty(eraaSoftSchools)) {
            return new ArrayList<>();
        }

        return eraaSoftSchools.stream().map(eraaSoftSchool ->
                eraaSoftMapper.toEraaSoftSchoolDto(eraaSoftSchool)).collect(Collectors.toList());
    }

    @Override
    public EraaSoftSchoolDTO getById(Long id) {
        Optional<EraaSoftSchool> eraaSoftSchoolOptional = eraaSoftSchoolRepo.findById(id);

        if (eraaSoftSchoolOptional.isEmpty()) {
            return null;
        }

        return eraaSoftMapper.toEraaSoftSchoolDto(eraaSoftSchoolOptional.get());
    }

    @Override
    public EraaSoftSchoolDTO getByUserName(String userName) {
        Optional <EraaSoftSchool> eraaSoftSchoolOptional = eraaSoftSchoolRepo.extractByUserName(userName);
        if (!eraaSoftSchoolOptional.isPresent()) {
            return null;
        }

        return eraaSoftMapper.toEraaSoftSchoolDto(eraaSoftSchoolOptional.get());
    }


}
