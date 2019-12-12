package com.cpe.dormsys.repository;

import com.cpe.dormsys.entity.EnrollVehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface EnrollVehicleRepository extends JpaRepository<EnrollVehicle, Long> {


}