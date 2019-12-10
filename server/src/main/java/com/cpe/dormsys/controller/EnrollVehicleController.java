package com.cpe.dormsys.controller;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.cpe.dormsys.entity.EnrollVehicle;
import com.cpe.dormsys.entity.RoomBooking;
import com.cpe.dormsys.entity.Staff;
import com.cpe.dormsys.entity.VehicleType;
import com.cpe.dormsys.repository.EnrollVehicleRepository;
import com.cpe.dormsys.repository.RoomBookingRepository;
import com.cpe.dormsys.repository.StaffRepository;
import com.cpe.dormsys.repository.VehicleTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EnrollVehicleController {

    @Autowired
    private final EnrollVehicleRepository enrollVehicleRepository;
    @Autowired
    private final RoomBookingRepository roomBookingRepository;
    @Autowired
    private final VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private final StaffRepository staffRepository;

    EnrollVehicleController(EnrollVehicleRepository enrollVehicleRepository) {
        this.enrollVehicleRepository = enrollVehicleRepository;
    }

    @GetMapping("/enrollVehicle")
    public Collection<EnrollVehicle> EnrollVehicles() {
        return enrollVehicleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/enrollVehicle/{roombooking_id}/{vehicleType_id}/{staff_id}")
    public EnrollVehicle newEnrollVehicle(EnrollVehicle newEnrollVehicle,
    @PathVariable long roombooking_id,
    @PathVariable long vehicleType_id,
    @PathVariable long staff_id,
    @PathVariable String licensePlate,
    @PathVariable String brandName,
    @PathVariable String otherDetails) {

        RoomBooking enrolledStudent = roomBookingRepository.findById(roombooking_id);
        VehicleType vehicletypeOfStudent = vehicleTypeRepository.findById(vehicleType_id);
        Staff createdBy = staffRepository.findById(staff_id);

        newEnrollVehicle.setEnrolledStudent(enrolledStudent);
        newEnrollVehicle.setVehicletypeOfStudent(vehicleType_id);
        newEnrollVehicle.setCreatedBy(staff_id);
        newEnrollVehicle.setEnrollDate(new Date());
        newEnrollVehicle.setLicensePlate(licensePlate);
        newEnrollVehicle.setBrandName(brandName);
        newEnrollVehicle.setOtherDetails(otherDetails);

        return enrollVehicleRepository.save(newEnrollVehicle);
    }
}