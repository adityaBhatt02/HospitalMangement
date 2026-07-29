package com.addyops.hospitalManagement.entity;

import com.addyops.hospitalManagement.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name_birthdate", columnNames = {"name", "birthdate"})
        },
        indexes = {
                @Index(name = "idx_patient_birthdate", columnList = "birthdate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String gender;

    @ToString.Exclude
    private LocalDate birthdate;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroup blood_group;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id")              // owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
