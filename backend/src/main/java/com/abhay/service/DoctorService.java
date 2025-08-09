package com.abhay.service;

import com.abhay.entity.Doctor;
import com.abhay.repository.DoctorRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public boolean addDoctor(Doctor doctor,String imageUrl){
        doctor.setProfile_image(imageUrl);
        Doctor res =doctorRepo.save(doctor);

        if (res!=null)return true;
        else return false;

    }

    public List findDoctorBySpacilization(String location,String specialization){
        List<Doctor> doctorlist = doctorRepo.findByLocationAndSpecialization(location,specialization).orElse(null);
        return doctorlist;

    }
}
