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
@Table(name = "STAFF")
public class Staff {

    @Id
    @SequenceGenerator(name="staf_seq",sequenceName="staf_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="staf_seq")  
    @Column(name = "STAFF_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String staffName;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<EnrollVehicle> enroll;
}