package com.example.Spring_Boot_Start_Project.repo;


import com.example.Spring_Boot_Start_Project.model.EraaSoftSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EraaSoftSchoolRepo extends JpaRepository<EraaSoftSchool, Long> {

    Optional <EraaSoftSchool> findByUserName(String userName);
    //nativeQuery = false DB ORACLE
    //nativeQuery = false default based on model

    @Query(value = "select * from Eraa_Soft_School where USER_NAME=:userName", nativeQuery = true)
//    @Query(value = "select ess from EraaSoftSchool ess where ess.userName = :userName")
    Optional <EraaSoftSchool> extractByUserName(@Param("userName") String userName);


}
