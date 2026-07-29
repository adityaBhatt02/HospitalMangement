package com.addyops.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String department;

    @OneToOne
    @JoinColumn(name = "head_doctor_id", unique = true)
    private Doctor headDoctor;

    @ManyToMany(mappedBy = "departments")
    private List<Doctor> doctors = new ArrayList<>();
}
