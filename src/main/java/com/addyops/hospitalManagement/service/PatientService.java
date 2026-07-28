package com.addyops.hospitalManagement.service;

import com.addyops.hospitalManagement.entity.Patient;
import com.addyops.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        return p1;
    }

    @Transactional
    public void getPatientUpdated(String name, Long id) {
        Patient p = patientRepository.findById(id).orElseThrow();
        System.out.println(p.getName());

        patientRepository.updateNameWithId(name, id);

        Patient p1 = patientRepository.findById(id).orElseThrow();
        System.out.println(p1.getName());
    }
}
