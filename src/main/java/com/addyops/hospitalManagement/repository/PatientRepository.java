package com.addyops.hospitalManagement.repository;

import com.addyops.hospitalManagement.entity.Patient;
import com.addyops.hospitalManagement.enums.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    Patient findByEmail(String email);
    List<Patient> findByNameOrEmail(String name , String email);
}
