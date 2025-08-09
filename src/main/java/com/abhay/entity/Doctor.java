package com.abhay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String specialization;
    private String location;
    private Integer experience;
    private Double rating;
    private String email;
    private String phone;
    private String profile_image;
    private boolean available;
    private LocalDateTime createdAT= LocalDateTime.now();

}
