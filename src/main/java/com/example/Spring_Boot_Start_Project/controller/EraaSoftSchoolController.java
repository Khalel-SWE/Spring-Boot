package com.example.Spring_Boot_Start_Project.controller;

import com.example.Spring_Boot_Start_Project.dto.EraaSoftSchoolDTO;
import com.example.Spring_Boot_Start_Project.service.EraaSoftSchoolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eraa-soft")
public class EraaSoftSchoolController {

    private EraaSoftSchoolService eraaSoftSchoolService;

    @Autowired
    public EraaSoftSchoolController(EraaSoftSchoolService eraaSoftSchoolService) {
        this.eraaSoftSchoolService = eraaSoftSchoolService;
    }

    @PostMapping("/save-student")
    ResponseEntity<EraaSoftSchoolDTO> addStudent (@RequestBody @Valid EraaSoftSchoolDTO eraaSoftSchool) {
        return ResponseEntity.ok(eraaSoftSchoolService.save(eraaSoftSchool));
    }

    @PutMapping("/update-student")
    ResponseEntity<EraaSoftSchoolDTO> updateStudent (@RequestBody EraaSoftSchoolDTO eraaSoftSchool) {
        return ResponseEntity.ok(eraaSoftSchoolService.update(eraaSoftSchool));
    }

    //http://localhost:8080/delete-student?studentId=4
    //http://localhost:8080/delete-/student/6
    @DeleteMapping("/delete/student")
    ResponseEntity<Void> deleteStudent (@RequestParam("studentId") Long id) {
//    boolean deleteStudent (@PathVariable Long id) {

        return eraaSoftSchoolService.delete(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/students")
    @PreAuthorize("hasRole('ADMEN')")
    ResponseEntity<List<EraaSoftSchoolDTO>> getAllStudent() {
        return ResponseEntity.ok(eraaSoftSchoolService.getAll());
    }

    @GetMapping("/student/{id}")
    ResponseEntity<EraaSoftSchoolDTO> getStudentById (@PathVariable Long id) {
        return ResponseEntity.ok(eraaSoftSchoolService.getById(id));
    }

    @GetMapping("/student/user-name/{userName}")
    ResponseEntity<EraaSoftSchoolDTO> getStudentById (@PathVariable String userName) {
        return ResponseEntity.ok(eraaSoftSchoolService.getByUserName(userName));
    }
}
