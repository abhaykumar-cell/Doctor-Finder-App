package com.abhay.controller;

import com.abhay.dto.SearchRequest;
import com.abhay.entity.Doctor;
import com.abhay.service.DoctorService;

import io.swagger.v3.oas.annotations.tags.Tag;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/docfinder")
@Tag(name = "Doctors", description = "Doctor Management APIs")

public class DoctorController {
    private DoctorService doctorService;
    @Value("${server.port}")
    private String port;



    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @PostMapping("/add")
    public ResponseEntity addDoctor(@ModelAttribute Doctor doctor, @RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) return new ResponseEntity("File not found !", HttpStatus.NOT_FOUND);
            String resourcePath = System.getProperty("user.dir")+"/uploads/";
            String fileName = UUID.randomUUID()+"_"+file.getOriginalFilename().replaceAll(" ","_");
            File directory = new File(resourcePath);
            if (!directory.exists()){
                directory.mkdirs();
            }
            Path filePath = Paths.get(resourcePath+fileName);

        Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        String imageUrl ="http://localhost:8081/images/"+fileName;

        doctorService.addDoctor(doctor,imageUrl);

        return new ResponseEntity("Doctor Added Successfully", HttpStatus.CREATED);

    }

    @PostMapping("/show")
    public ResponseEntity showDocto(@RequestBody SearchRequest request){
        List doctorList = doctorService.findDoctorBySpacilization(request.getLocation(),request.getSpecialization());
        if (!doctorList.isEmpty()) return new ResponseEntity(doctorList,HttpStatus.OK);
        else return  new ResponseEntity("Doctor's Not Available in "+request.getLocation(),HttpStatus.NOT_FOUND);
    }
}
