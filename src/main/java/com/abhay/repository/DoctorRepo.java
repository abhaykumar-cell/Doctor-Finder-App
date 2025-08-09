package com.abhay.repository;

import com.abhay.entity.Doctor;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    Optional<List<Doctor>> findByLocationAndSpecialization(String location, String specialization);

}
