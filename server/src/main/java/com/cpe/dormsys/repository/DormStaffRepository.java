package com.cpe.dormsys.repository;

import com.cpe.dormsys.entity.DormStaff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DormStaffRepository extends JpaRepository<DormStaff, Long> {
    DormStaff findById(long id);    
}