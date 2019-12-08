package com.cpe.dormsys.controller;

import java.sql.Date;
import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.dormsys.entity.DormStaff;
import com.cpe.dormsys.entity.EnrollVehicle;
import com.cpe.dormsys.entity.RoomBooking;
import com.cpe.dormsys.entity.VehicleType;
import com.cpe.dormsys.repository.DormStaffRepository;
import com.cpe.dormsys.repository.EnrollVehicleRepository;
import com.cpe.dormsys.repository.RoomBookingRepository;
import com.cpe.dormsys.repository.VehicleTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class EnrollVehicleController {

    @Autowired
    private final EnrollVehicleRepository enrollVehicleRepository;
    @Autowired
    private final DormStaffRepository dormStaffRepository;
    @Autowired
    private final VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private final RoomBookingRepository roomBookingRepository;

    EnrollVehicleController(EnrollVehicleRepository enrollVehicleRepository) {
        this.enrollVehicleRepository = enrollVehicleRepository;
    }

    @GetMapping("/EnrollVehicle")
    public Collection<EnrollVehicle> getEnrollVehicles() {
        return enrollVehicleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/NewEnrollVehicle")
    public EnrollVehicle newEnrollVehicle(EnrollVehicle newEnrollVehicle,
    @PathVariable long dormstaff_id,
    @PathVariable long vehicletype_id,
    @PathVariable long roombooking_id,
    @PathVariable Date enrollDate) {

        DormStaff staffname = dormStaffRepository.findById(dormstaff_id);
        VehicleType type = vehicleTypeRepository.findById(vehicletype_id);
        RoomBooking studentname = roomBookingRepository.findById(roombooking_id);

        newEnrollVehicle.setStaffname(staffname);
        newEnrollVehicle.setType(type);
        newEnrollVehicle.setStudentname(studentname);
        newEnrollVehicle.setEnrollDate(enrollDate);
        
        return enrollVehicleRepository.save(newEnrollVehicle);
    }
}