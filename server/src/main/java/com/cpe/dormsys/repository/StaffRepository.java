package com.cpe.dormsys.repository;

import com.cpe.dormsys.entity.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findById(long id);
}