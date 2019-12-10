package com.cpe.dormsys.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.dormsys.entity.Staff;
import com.cpe.dormsys.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class StaffController {

    @Autowired
    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("/staff")
    public Collection<Staff> Staffs() {
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }
}