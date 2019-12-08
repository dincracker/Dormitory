package com.cpe.dormsys.repository;

import com.cpe.dormsys.entity.VehicleType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    VehicleType findById(long id);    
}