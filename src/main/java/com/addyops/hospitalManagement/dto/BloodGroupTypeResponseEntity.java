package com.addyops.hospitalManagement.dto;

import com.addyops.hospitalManagement.enums.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupTypeResponseEntity {
    private BloodGroup bloodGroup;
    private Long id;
}
