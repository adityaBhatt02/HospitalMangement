package com.addyops.hospitalManagement;

import com.addyops.hospitalManagement.entity.Patient;
import com.addyops.hospitalManagement.repository.PatientRepository;
import com.addyops.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testPatientById() {
        Patient p = patientService.getPatientById(1L);
        System.out.println(p);
    }
}
