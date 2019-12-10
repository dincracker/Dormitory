package com.cpe.dormsys;

import java.util.stream.Stream;

import com.cpe.dormsys.entity.RoomBooking;
import com.cpe.dormsys.entity.Staff;
import com.cpe.dormsys.entity.VehicleType;
import com.cpe.dormsys.repository.RoomBookingRepository;
import com.cpe.dormsys.repository.StaffRepository;
import com.cpe.dormsys.repository.VehicleTypeRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DormitoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DormitoryApplication.class, args);
	}

	@Bean
	ApplicationRunner init(RoomBookingRepository roomBookingRepository, VehicleTypeRepository vehicleTypeRepository, StaffRepository staffRepository) {
		return args -> {
			Stream.of("Nattha", "Suthai", "TeastLah").forEach(studentName -> {
				RoomBooking roomBooking = new RoomBooking();
				roomBooking.setStudentName(studentName);
				roomBookingRepository.save(roomBooking);
			});

			Stream.of("S800", "S801", "S802").forEach(roomNo -> {
				RoomBooking roomBooking = new RoomBooking();
				roomBooking.setRoomNo(roomNo);
				roomBookingRepository.save(roomBooking);
			});

			Stream.of("Nattha", "Suthai", "TeastLah").forEach(staffName -> {
				Staff staff = new Staff();
				staff.setStaffName(staffName);
				staffRepository.save(staff);
			});

			Stream.of("Nattha", "Suthai", "TeastLah").forEach(type -> {
				VehicleType vehicleType = new VehicleType();
				vehicleType.setType(type);
				vehicleTypeRepository.save(vehicleType);
			});

			roomBookingRepository.findAll().forEach(System.out::println);
			vehicleTypeRepository.findAll().forEach(System.out::println);
			staffRepository.findAll().forEach(System.out::println);
		};
	}
}
