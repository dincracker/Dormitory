package com.cpe.dormsys.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.dormsys.entity.RoomBooking;
import com.cpe.dormsys.repository.RoomBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RoomBookingController {

    @Autowired
    private RoomBookingRepository roomBookingRepository;

    // public RoomBookingController(RoomBookingRepository roomBookingRepository) {
    //     this.roomBookingRepository = roomBookingRepository;
    // }

    @GetMapping("/roomBookings")
    public Collection<RoomBooking> getVehicleTypes() {
        return roomBookingRepository.findAll().stream().collect(Collectors.toList());
    }
}