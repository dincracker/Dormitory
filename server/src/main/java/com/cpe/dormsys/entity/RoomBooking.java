package com.cpe.dormsys.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.NonNull;

public class RoomBooking {

    @Id
    @SequenceGenerator(name = "room_booking_seq", sequenceName = "room_booking_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_booking_seq")
    @Column(name = "ROOM_BOOKING_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String studentName;

    private @NonNull String RoomNo;
    
    public RoomBooking() {}

    public RoomBooking(String studentName) {
        this.studentName = studentName;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<EnrollVehicle> enroll;
}