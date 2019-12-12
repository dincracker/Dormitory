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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EnrollVehicleController {

    @Autowired
    private EnrollVehicleRepository enrollVehicleRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private RoomBookingRepository roomBookingRepository;

    // EnrollVehicleController(final EnrollVehicleRepository
    // enrollVehicleRepository) {
    // this.enrollVehicleRepository = enrollVehicleRepository;
    // }

    @GetMapping("/enrollVehicle")
    public Collection<EnrollVehicle> getEnrollVehicles() {
        return enrollVehicleRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/enrollVehicle/{staff_id}/{vehicleType_id}/{roomBooking_id}")
    public EnrollVehicle newEnrollVehicle(EnrollVehicle newEnrollVehicle, @PathVariable long staff_id,
            @PathVariable long vehicleType_id, @PathVariable long roomBooking_id) {

        Staff craetedBy = staffRepository.findById(staff_id);
        VehicleType typeOfVehicle = vehicleTypeRepository.findById(vehicleType_id);
        RoomBooking enrolledStudents = roomBookingRepository.findById(roomBooking_id);

        newEnrollVehicle.setCraetedBy(craetedBy);
        newEnrollVehicle.setTypeOfVehicle(typeOfVehicle);
        newEnrollVehicle.setEnrolledStudents(enrolledStudents);
        newEnrollVehicle.setEnrollDate(new Date());
        // newEnrollVehicle.setLicensePlate(licensePlate);

        return enrollVehicleRepository.save(newEnrollVehicle);
    }
}