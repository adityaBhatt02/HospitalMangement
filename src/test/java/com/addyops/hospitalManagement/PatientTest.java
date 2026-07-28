package com.addyops.hospitalManagement;

import com.addyops.hospitalManagement.entity.Patient;
import com.addyops.hospitalManagement.enums.BloodGroup;
import com.addyops.hospitalManagement.repository.PatientRepository;
import com.addyops.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    public void JPAqueryMethodCheck() {
//        Patient p = patientRepository.findByName("Aayushi");
//        System.out.println(p);
//
//        Patient p1 = patientRepository.findByEmail("aditya.adi02bhatt@gmail.com");
//        System.out.println(p1);
//
//        List<Patient> patientList = patientRepository.findByNameOrEmail("Rahul", "rads@gmail.com");
//        for(Patient p3 : patientList) {
//            System.out.println(p3);
//        }
//
//        List<Patient> patientList1 = patientRepository.findByBloodGroup(BloodGroup.B_POSITIVE);
//        for(Patient p4 : patientList1) {
//            System.out.println(p4);
//        }
//
//
//        List<Object[]> result = patientRepository.countPatientByBloodGroup();
//        for(Object[] row : result) {
//            System.out.println(row[0] + " : " + row[1]);
//        }

//        patientService.getPatientUpdated("Radhika", 5L);

        Pageable pageable = PageRequest.of(0,3);
        Page<Patient> page = patientRepository.findAll(pageable);
        for(Patient patient : page) {
            System.out.println(patient);
        }
    }
}
