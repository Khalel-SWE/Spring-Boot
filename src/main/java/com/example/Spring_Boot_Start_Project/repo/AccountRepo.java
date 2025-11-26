package com.example.Spring_Boot_Start_Project.repo;

import com.example.Spring_Boot_Start_Project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<Account> findByUserName(String name);

//    @Query(value = "SELECT acc from Account acc where acc.name like %:name%")
//    List<Account> search (@Param("name") String name);
}
