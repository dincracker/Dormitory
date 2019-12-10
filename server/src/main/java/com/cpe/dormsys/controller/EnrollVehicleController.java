package com.cpe.dormsys.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.dormsys.entity.EnrollVehicle;
import com.cpe.dormsys.entity.RoomBooking;
import com.cpe.dormsys.entity.Staff;
import com.cpe.dormsys.entity.VehicleType;
import com.cpe.dormsys.repository.EnrollVehicleRepository;
import com.cpe.dormsys.repository.RoomBookingRepository;
import com.cpe.dormsys.repository.StaffRepository;
import com.cpe.dormsys.repository.VehicleTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EnrollVehicleController {

    @Autowired
    private final EnrollVehicleRepository enrollVehicleRepository;
    @Autowired
    private RoomBookingRepository roomBookingRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private StaffRepository staffRepository;

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
        newEnrollVehicle.setVehicletypeOfStudent(vehicletypeOfStudent);
        newEnrollVehicle.setCreatedBy(createdBy);
        newEnrollVehicle.setEnrollDate(new Date());
        newEnrollVehicle.setLicensePlate(licensePlate);
        newEnrollVehicle.setBrandName(brandName);
        newEnrollVehicle.setOtherDetails(otherDetails);

        return enrollVehicleRepository.save(newEnrollVehicle);
    }
}