package com.cpe.dormsys.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "DORM_STAFF")
public class DormStaff {

    @Id
    @SequenceGenerator(name = "dorm_staff_seq", sequenceName = "dorm_staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dorm_staff_seq")
    @Column(name = "DORM_STAFF_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;

    public DormStaff() {}

    public DormStaff(String name) {
        this.name = name;
    }
    
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<EnrollVehicle> enroll;
}