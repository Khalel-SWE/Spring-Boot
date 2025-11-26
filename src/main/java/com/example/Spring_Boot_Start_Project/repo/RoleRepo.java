package com.example.Spring_Boot_Start_Project.repo;

import com.example.Spring_Boot_Start_Project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
