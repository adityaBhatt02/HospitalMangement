package com.addyops.hospitalManagement.repository;

import com.addyops.hospitalManagement.entity.Patient;
import com.addyops.hospitalManagement.enums.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    Patient findByEmail(String email);
    List<Patient> findByNameOrEmail(String name , String email);

    @Query("SELECT p FROM Patient p WHERE p.blood_group = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    @Query("""
           SELECT p.blood_group, COUNT(p) 
           FROM Patient p 
           WHERE p.blood_group IS NOT NULL 
           GROUP BY p.blood_group
          """)
    List<Object[]> countPatientByBloodGroup();

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
           UPDATE Patient p
           SET p.name = :name
           WHERE p.id = :id
          """)
    void updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
